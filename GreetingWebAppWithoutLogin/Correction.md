# Correction Steps: Spring Context Loading Issue in GreetingServlet

This document outlines the steps taken to resolve the runtime initialization issue in `GreetingServlet.java` where the Spring application context was failing to load correctly under Tomcat.

---

## 🔍 The Problem Analyzed

The previous servlet code attempted to initialize the Spring context using `ClassPathXmlApplicationContext` by passing a physical file system path retrieved via `ServletContext.getRealPath()`:
```java
String xmlPath = getServletContext().getRealPath("/WEB-INF/applicationContext.xml");
context = new ClassPathXmlApplicationContext("file:" + xmlPath);
```

### Why it failed:
1. **Invalid ClassLoader Context**: `ClassPathXmlApplicationContext` is designed to scan the java classpath (`WEB-INF/classes` or libraries in `WEB-INF/lib`). Passing an absolute filesystem path via `file:` is an anti-pattern and often fails due to class resolution restrictions within Tomcat.
2. **WAR Deployment Risk**: If the web application is deployed as a packaged WAR file (non-exploded), `getRealPath()` returns `null`, causing a `NullPointerException` or `FileNotFoundException`.
3. **Windows File Path Compatibility**: In Windows, local file paths use backslashes (`\`) which don't map cleanly to URI/URL schemas expected by Spring resource loaders without explicit sanitization.

---

## 🛠️ The Solution (Implemented)

We resolved the issue using the standard Spring Web Integration pattern (**Option 1**), which separates context loading lifecycle from servlet initialization.

### Step 1: Update `web.xml`
We registered Spring's `ContextLoaderListener` to bootstrap the Spring context when the web application starts up. This makes the Spring context available globally via the `ServletContext`.

*Modified File:* `web/WEB-INF/web.xml`
```xml
<!-- Configure the location of the Spring XML configuration file -->
<context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>/WEB-INF/applicationContext.xml</param-value>
</context-param>

<!-- Bootstrap Spring Context when the Web Application starts -->
<listener>
    <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
</listener>
```

### Step 2: Modify `GreetingServlet.java`
We updated the servlet to look up the pre-loaded Spring root context using `WebApplicationContextUtils` instead of trying to instantiate a new `ClassPathXmlApplicationContext` directly.

*Modified File:* `src/com/greet/servlet/GreetingServlet.java`
```java
// Import the appropriate WebApplicationContextUtils helper
import org.springframework.web.context.support.WebApplicationContextUtils;

@Override
public void init() throws ServletException {
    super.init();
    System.out.println("=== GreetingServlet.init() — Retrieving Spring Context ===");
    
    // Retrieve the Spring Context initialized by ContextLoaderListener
    context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
    
    // Retrieve the GreetingService bean from Spring context
    greetingService = (GreetingService) context.getBean("greetingService");
    
    System.out.println("=== Spring Context retrieved successfully ===");
    System.out.println(" GreetingService bean: " + greetingService);
}
```

---

## 🚀 Compilation & Execution Steps (IntelliJ IDEA Ultimate)

Follow these steps to compile and run the project using IntelliJ IDEA Ultimate:

### 🛠️ Steps to Configure and Use JDK 21 (Resolving JVM Target 26 Error)

If you see the build error `java: Cannot compile module 'GreetingWebApp' configured for JVM target 26` or wish to use **JDK 21** instead of JDK 26, you must align the compiler target bytecode version and SDK settings to Java 21 in IntelliJ IDEA:

1. **Configure Java Compiler (Bytecode Target)**:
   - Go to **File** -> **Settings...** (or press `Ctrl + Alt + S`).
   - Navigate to **Build, Execution, Deployment** -> **Compiler** -> **Java Compiler**.
   - Change the **Project bytecode version** dropdown to `21`.
   - Under **Per-module bytecode version** in the table below, find the `GreetingWebApp` module and set its Target bytecode version to `21`.
   - Click **Apply**.

2. **Configure Project SDK**:
   - Go to **File** -> **Project Structure...** (or press `Ctrl + Alt + Shift + S`).
   - Click on **Project** under *Project Settings* on the left panel.
   - Set the **SDK** dropdown to your JDK 21 installation (e.g., `ms-21` or download JDK 21 if not already added).
   - Set the **Language level** dropdown to `21 - JDK 21`.

3. **Verify Module SDK**:
   - In the same Project Structure dialog, click on **Modules** on the left panel.
   - Select the `GreetingWebApp` module.
   - Click on the **Dependencies** tab.
   - Ensure the **Module SDK** dropdown is set to `Project SDK` (or select your JDK 21 / `ms-21` directly).
   - Click **OK** to save and apply the settings.

4. **Rebuild the Project**:
   - Go to the **Build** menu in the top menu bar.
   - Click **Rebuild Project** to clean and compile the application with the new JDK 21 target.

---

### ⚠️ Troubleshooting: "Cannot access org.springframework.core.env.EnvironmentCapable" Error

If you see the build error `java: cannot access org.springframework.core.env.EnvironmentCapable` / `class file for org.springframework.core.env.EnvironmentCapable not found` even though the dependency `spring-core-6.1.6.jar` is visible in your **Project Structure** dialog:

This happens because the IDE's compiler cache is still using the old classpath. Follow these exact steps to apply the dependency and solve it:

1. **Apply and Save Project Structure Dialog**:
   - In the currently open **Project Structure** dialog, click the **Apply** button at the bottom-right.
   - Click the **OK** button to close the dialog. This saves the dependency classpath.
2. **Perform a Clean Rebuild**:
   - Go to the **Build** menu in the top menu bar of IntelliJ.
   - Click **Rebuild Project** (do not just click "Build Project"). A clean rebuild forces the compiler to reload the classpath with the newly added `spring-core-6.1.6.jar` dependency.
3. **If IDE Cache is Still Stale**:
   - If the error persists, go to **File** -> **Invalidate Caches...**.
   - Select **Clear file system cache and Local History** and click **Invalidate and Restart**. This will clear all compiler/IDE metadata caches and force a fresh resolution.

---

### 1. Compile the Project
1. Open the project in **IntelliJ IDEA Ultimate**.
2. Click on the **Build** menu in the top menu bar.
3. Select **Build Project** (or use the shortcut `Ctrl + F9` on Windows).
4. IntelliJ will compile your classes and place them inside the `out/production/GreetingWebApp` folder. It will also build the exploded WAR artifact inside `out/artifacts/GreetingWebApp`.

### 2. Deploy and Run under Tomcat
1. Look at the top-right toolbar in the IDE. You will see a dropdown containing run configurations, which should display **Tomcat 10.1.55**.
2. Click the green **Run (Play)** button next to it (or press `Shift + F10`).
3. IntelliJ will start the Tomcat server and automatically deploy the exploded WAR file.
4. Check the **Services** or **Run** tool window at the bottom of the IDE to see the server output. Verify that you see the successful initialization logs:
   ```text
   === GreetingServlet.init() — Retrieving Spring Context ===
   === Spring Context retrieved successfully ===
   GreetingService bean: com.greet.service.GreetingServiceImpl@...
   ```

### 3. Verify the Application in Browser
1. Once Tomcat has finished deploying, open your browser.
2. Navigate to: [http://localhost:8080/GreetingWebApp/greet](http://localhost:8080/GreetingWebApp/greet)
3. Enter a name in the form and click **Submit**.
4. You should see the successful greeting page generated by `GreetingService` (e.g., *"Hello, [Name]!"*).
