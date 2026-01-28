package org.example.base;

import org.example.core.config.ConfigManager;
import org.example.core.context.TestExecutionContext;
import org.example.tests.listeners.FrameworkStartedLogger;
import org.example.tests.listeners.FrameworkStoppedLogger;
import org.example.tests.plugins.AllureReportingPlugin;
import org.example.tests.plugins.ApiLoggingPlugin;
import org.example.tests.plugins.RetryPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.example.core.event.EventBus;
import org.example.core.event.events.FrameworkStartedEvent;
import org.example.core.event.events.FrameworkStoppedEvent;
import org.example.core.plugin.PluginManager;
import org.example.tests.plugins.LifecycleLoggingPlugin;
import org.example.engine.data.DataProviderFactory;
import org.example.engine.data.JsonDataProvider;
import org.example.engine.schema.SchemaValidatorFactory;
import org.example.engine.schema.JsonSchemaValidator;
import org.example.core.http.HttpClient;
import org.example.core.http.impl.RestAssuredHttpClient;
import org.example.service.booking.BookingService;
import org.example.service.booking.impl.BookingServiceImpl;


import java.util.Map;

public class BaseTest {

    protected static final Logger log = LoggerFactory.getLogger(BaseTest.class);
    protected static HttpClient httpClient;
    protected static BookingService bookingService;



    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        log.info("==============================================");
        log.info("🚀 Starting API Test Platform");
        log.info("==============================================");

        // Load environment
        String env = ConfigManager.getEnv();
        TestExecutionContext.setEnv(env);

        // Load full env config map
        Map<String, Object> envConfig = ConfigManager.getEnvConfig();
        TestExecutionContext.setConfig(envConfig);

        DataProviderFactory.init(new JsonDataProvider("testdata.json"));
        log.info("✅ Data Engine initialized (JsonDataProvider)");

        SchemaValidatorFactory.init(new JsonSchemaValidator());
        log.info("✅ Schema Engine initialized (JsonSchemaValidator)");



        log.info("Running in environment: {}", TestExecutionContext.getEnv());
        log.info("Base URL from config: {}", TestExecutionContext.getConfig().get("baseUrl"));

        log.info("✅ FrameworkContext initialized");
        log.info("✅ Framework initialization completed");


        EventBus.register(FrameworkStartedEvent.class, new FrameworkStartedLogger());
        EventBus.register(FrameworkStoppedEvent.class, new FrameworkStoppedLogger());
        // Initialize and start plugins
        PluginManager.register(new LifecycleLoggingPlugin());

        httpClient = new RestAssuredHttpClient();
        log.info("✅ HttpClient initialized (RestAssured)");

// Initialize Services
        bookingService = new BookingServiceImpl(httpClient);
        log.info("✅ BookingService initialized");

        EventBus.publish(new FrameworkStartedEvent());
        log.info("📣 FrameworkStartedEvent published");

        PluginManager.register(new ApiLoggingPlugin());

        PluginManager.register(new RetryPlugin(2));

        PluginManager.register(new AllureReportingPlugin());



    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        log.info("==============================================");
        log.info("🛑 Shutting down API Test Platform");
        log.info("==============================================");

        // Clear context
        TestExecutionContext.clear();

        log.info("✅ FrameworkContext cleared");
        log.info("✅ Framework shutdown completed");

        EventBus.publish(new FrameworkStoppedEvent());
        log.info("📣 FrameworkStoppedEvent published");

    }
}
