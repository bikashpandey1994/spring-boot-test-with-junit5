

#Introduction to Junit


- **Junit Platform :** It is a bridge between build tools/IDE and Junit Runners.The platform is responsible for launching testing frameworks.

- **Junit Jupiter :** Introduced in Junit 5. Contains new programming and extension models for writing tests in Unit5.
	@TestFactory – denotes a method that’s a test factory for dynamic tests.
	@DisplayName – defines a custom display name for a test class or a test method.
	@Nested – denotes that the annotated class is a nested, non-static test class
	@Tag – declares tags for filtering tests
	@ExtendWith – registers custom extensions
	@BeforeEach – denotes that the annotated method will be executed before each test method (previously @Before)
	@AfterEach – denotes that the annotated method will be executed after each test method (previously @After)
	@BeforeAll – denotes that the annotated method will be executed before all test methods in the current class (previously @BeforeClass)
	@AfterAll – denotes that the annotated method will be executed after all test methods in the current class (previously @AfterClass)
	@Disabled – disables a test class or method (previously @Ignore)

- **JUnit Vintage :** supports running tests based on JUnit 3 and JUnit 4 on the JUnit 5 platform.
- **Assertions :**
	```
	assertTrue(Condition,() -> {...});
	assertFalse(Condition,() -> {...});
	assertEquals(this, that);
	assertThrows(UnsupportedOperationException.class, () -> {throw new UnsupportedOperationException("Not supported");
	assertAll("numbers",
         	() -> assertEquals(this, that),
         	() -> assertEquals(this, that),
         	() -> assertEquals(this, that)
     	);
	```
- **Assumptions :** Assumptions are used to run tests only if certain conditions are met. If an assumption fails, a TestAbortedException is thrown and the test is simply skipped.
- **Test Suites :** Aggregating multiple test classes in a test suite,
	```
	@Suite
	@SelectPackages("com.baeldung")
	@ExcludePackages("com.baeldung.suites")
	public class AllUnitTest {}
	```
- **Dynamic Tests :** TBR
- **Junit5 Extensions :** TBR
- 



#Spring Boot Test with Junit


1. 	**@ExtendWith(SpringRunner.class) :** This provides following support to you tests.
		- Spring support.
		- @MockBean support.
		- @Autowire support.
		- @TestConfiguration support.You have to create and configure beans manually using  @TestConfiguration

2.	**@WebMvcTest :** This provides following support to you tests. 
		- Spring support.
		- @MockBean support.
		- @Autowire support.
		- @TestConfiguration support.You have to create and configure beans other than Web layer beans though  @TestConfiguration or @MockBean
		- @AutoConfigureMockMvc Support.
		- Automatic web layer bean initialization.

3.	**@DataJpatest :** This provides following support to you tests.
		- Configuring H2, an in-memory database
		- Setting Hibernate, Spring Data, and the DataSource
		- Performing an @EntityScan
		- Turning on SQL logging

4. 	**@SpringBootTest :**
		- Spring support.
		- @MockBean support.
		- @Autowire support.
		- @TestConfiguration support.
		- Automatic bean initialization and autowiring using configuration class (one with @SpringBootApplication, for 	instance).

5. 	**Apart from these there others as well**
	
		- @WebFluxTest: We can use the @WebFluxTest annotation to test Spring WebFlux controllers. It’s often used along with @MockBean to provide mock implementations for required 			dependencies.
		- @JdbcTest: We can use the @JdbcTest annotation to test JPA applications, but it’s for tests that only require a DataSource. The annotation configures an in-memory 				embedded database and a JdbcTemplate.
		- @JooqTest: To test jOOQ-related tests, we can use @JooqTest annotation, which configures a DSLContext.
		- @DataMongoTest: To test MongoDB applications, @DataMongoTest is a useful annotation. By default, it configures an in-memory embedded MongoDB if the driver is available 			through dependencies, configures a MongoTemplate, scans for @Document classes, and configures Spring Data MongoDB repositories.
		- @DataRedisTestmakes it easier to test Redis applications. It scans for @RedisHash classes and configures Spring Data Redis repositories by default.
		- @DataLdapTest configures an in-memory embedded LDAP (if available), configures a LdapTemplate, scans for @Entry classes, and configures Spring Data LDAP repositories by 			default.
		- @RestClientTest: We generally use the @RestClientTest annotation to test REST clients. It auto-configures different dependencies such as Jackson, GSON, and Jsonb support; 			configures a RestTemplateBuilder; and adds support for MockRestServiceServer by default.
		- @JsonTest: Initializes the Spring application context only with those beans needed to test JSON serialization.
		

6. 	**@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK) :** This tells Spring Boot to create the application context and run servlets in a mocked environment without a 	server.

7.	**@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) :** This tells springboot to create the application context and run the server with a random port.

8. 	**@LocalServerPort :** You can access the random port using this annotation.

9. 	**@AutoConfigureMockMvc :** This configures the MockMvc.
























