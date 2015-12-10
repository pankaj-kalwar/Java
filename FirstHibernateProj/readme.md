Hibernate Annotation Descriptions
--------------------------------------------------


@Entity(name="Table") vs @Entity @Table(name="Table")
--------------------------------------------------------
@Entity(name="Table") - It overrides the default entity with this name i.e If my class name is TableDetails than it overrides the entity name with Table as well as the table name in DB

 @Entity
 @Table(name="Table") -  It only overrides the Table name for DB not the entity name i.e. you can simply use the class name for you HQL queries
 
----------------------------- 
 
Some Important Annotations
--------------------------------------------------
 
 @Basic - just to define the fetch type or make field optional
 
 @Transient - Making Field non persistent
 
 @Temporal - Used to define the date either in date/time/Timestamp
 	
	e.g.
 	
	 	1. @Temporal(TemoralType.DATE)
	 	2. @Temporal(TemoralType.TIME)
	 	3. @Temporal(TemoralType.TIMESTAMP) - it's a default 	
 	
 @Lob - Used to define a field as a large object, i.e. the output column size in a table is more than 255 character 
 
 @GeneratedValue - Used to define the primary key 
 	
	e.g.
	
		@GeneratedValue(strategy=GenerationType.AUTO)
 	
 		Strategy Types
 		-----------------
 	
	 	1. AUTO [Default] - Automatically choose the identity, sequence  or table based on the db
	 	2. IDENTITY - 
	 	3. SEQUENCE - Fetch sequence from sequence table than update current sequence and than add it to your table
	 	4. TABLE - Creating a new hibernate_sequence table than inserting sequence_name, sequence_next_hi_value and than updating sequence_next_hi_value and than insert ids in your table


For making an object as embedded object
@Embeddable - Used to make embeddable object while defining a class 
	
	e.g.
	 
		@Embeddable
		public class User{
		}
 
 @Embedded - Used to access the embeddable objects in another class, even if not mentioned it acts as embedded
 	
	e.g.
	 
		@Embedded
		private User user;
		
		NOTE : Not possible to use both @Id & @Embedded at the same time.
		
@AttributeOverrides - used to define multiple @AttributeOverride
@AttributeOverride - used to override the embeddable column names
	
	e.g.
		
		@Embedded
		@AttributeOverrides({
			@AttributeOverride(name="city", column=@Column(name="home_city_name")),
			@AttributeOverride(name="state", column=@Column(name="home_state_name")),
			@AttributeOverride(name="pincode", column=@Column(name="home_pincode")),
			@AttributeOverride(name="street", column=@Column(name="home_street_name"))
		})
		private Address homeAddress;
		
@EmbeddedId - Used to make composite key
	
	e.g.
	
		@Embeddable
		public class User{
			private String firstName;
			private String lastName;
		}
		
		@EmbeddedId
		private User user;
		
		- in this example, it make composite key with firstName and lastName 
 
 @ElementCollection -  Used to add collections of embedded objects. 
 	
	e.g.
	
		@ElementCollection
		private Set<Address> listOfAddress = new HashSet<Address>();
		
		- in this example, it creates the separate table i.e. UserDetails_listOfAddress which holds the data i.e. primary key of UserDetails table and the fields present in embedded object
 
 @JoinTable -  Used to give the name of the Embedded table  
 	
	e.g.
	
		Attributes Used as,
		name - to give the user defined table name 
		joinColumns - used to give the user defined foreign key name
		
		@ElementCollection
		@JoinTable(name="user_address", joinColumns=@JoinColumn(name="user_id"))
		private Set<Address> listOfAddress = new HashSet<Address>();
		
@CollectionId - used to give the auto generated id i.e. primary key to the embedded table

@GenericGenerator - used to give the ID generator strategy 
Refer Link - http://stackoverflow.com/questions/10041938/how-to-choose-the-id-generation-strategy-when-using-hibernate	
		 	
 	
	e.g.
	
		Attributes Used as,
		columns - used to define the column name for making it primary 
		generator - should use the generator name defined in @GenericGenerator 
		type - defines the data type of the new column 
		
		
		@ElementCollection
		@JoinTable(name="user_address", joinColumns=@JoinColumn(name="user_id"))	
		@GenericGenerator(name="hilo-gen", strategy="hilo")
		@CollectionId(columns = { @Column(name="address_id") }, generator = "hilo-gen", type = @Type(type="long"))
		private Collection<Address> listOfAddress = new ArrayList<Address>();
------------------------------------------------------

Fetching a data - Proxy objects/Eager/Lazy
-------------------------------------------

Refer link - http://www.dineshonjava.com/p/proxy-objects-and-eager-and-lazy-fetch.html#.VhOY2Pmqqko 

Types-

	1. Eager
	2. Lazy(Default) 
	
	e.g.
	
		@ElementCollection//(fetch=FetchType.EAGER)
		@JoinTable(name="user_address", joinColumns=@JoinColumn(name="user_id"))
		//@Fetch(value = FetchMode.SELECT)	
		private Collection<Address> listOfAddress = new ArrayList<Address>();
 
 Mapping
-------------------------------------------
 
 Types
 	
1. One to one - Mainly defined using @OneToOne annotation. 
	
	e.g.
	
		@OneToOne
		@JoinColumn(name = "vehicle_id")
		private Vehicle vehicle;
		
		- In this example one user has one vehicle. While saving a data you have to save vehicle also,
		if you are not saving vehicle than it throws "org.hibernate.TransientObjectException"  
		
2. One to many <-> Many to one - used while referencing one to many relation

	e.g.	
		public class UserDetails{
			OneToMany
			@JoinTable(name = "USER_VEHICLE", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID"))
			private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();
	
		}
		
		public class Vehicle{
			@ManyToOne
			@JoinColumn(name = "USER_ID")
			private UserDetails2 userDetails2;
		}
		
		- in this example it will create a separate table i.e. USER_VEHICLE with columns user_id and vehicle_id 
		
	by Using "mappedBy" attribute - which the reference with the table
		
		public class UserDetails{
			OneToMany(mappedBy="userDetails2")			
			private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();
	
		}
		
		public class Vehicle{
			@ManyToOne
			@JoinColumn(name = "USER_ID")
			private UserDetails2 userDetails2;
		}
		
		- in this example it will not create separate table instead create reference column in Vehicle table
			
3. Many to many - Used to make many to many or bidirectional relationship


Semantics
--
- Bag Semantic (List/ArrayList)
- Bag Semantic with ID (List/ArrayList)
- List Semantic (List/ArrayList)
- Set Semantic
- Map Semantic


Inheritance
------------------------------------------------------------
Refer this package in project - com.beyondalgo.hibernate.inheritanceExample

- Created 3 entities and extended the "Vehicle" entity to child entities like(TwoWheeler & FourWheeler)
- After executing i.e. saving all the entities, it will save the data in single parent table.
- By default it will create one more column i.e. "DType" - Descriminator Type, which actaully descriminate the entities in a table 

Hibernate has 3 different inheritance type

	1. SingleTable (Default)
	2. Table Per class
	3. Join

1.	Single Table

- Its a default strategy.
- Basically used to add all data in a single table
- Developer can define their own discriminator instead of the default one by using
@DiscriminatorColumn in parent and @DiscriminatorValue in child

	e.g.
	
	/* Parent Class*/
	@Entity
	@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
	@DiscriminatorColumn(
			name="VEHICLE_TYPE",
			discriminatorType=DiscriminatorType.STRING
	)
	public class VehicleForInheritance {
		// Code Here
	}
	
	/* Child Class*/
	@Entity
	@DiscriminatorValue(value="Bike")
	public class TwoWheeler extends VehicleForInheritance {
		// Code Here
	}
	
	

2. Table Per class

- To overcome the cons of single table strategy we used this.
- It make the entities in normalized form, thats why we don't require to discriminator to discriminate the child entities
- Disadvantage : Repeated columns in child tables.

	e.g.
	
	/* Parent Class*/
	@Entity
	@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
	public class VehicleForInheritance {
		@Id
		@GeneratedValue
		private int id;
	}
	
	/* Child Class*/
	@Entity
	public class TwoWheeler extends VehicleForInheritance {
		// Code Here
	}
	
	- When executing above example, you will get exception like, 
	"org.hibernate.MappingException: Cannot use identity column key generation with <union-subclass> mapping for"
	
	Because by default the Id generation type is AUTO which is column based id generation
	- To Resolve this simple add Id generation strategy as 		@GeneratedValue(strategy=GenerationType.TABLE)
	- Reference - http://stackoverflow.com/questions/916169/cannot-use-identity-column-key-generation-with-union-subclass-table-per-clas
	- Let's consider the above example with modified generation types
	
	e.g.
	
	/* Parent Class*/
	@Entity
	@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
	public class VehicleForInheritance {
		@Id
		@GeneratedValue(strategy=GenerationType.TABLE)
		private int id;
	}
	
	/* Child Class*/
	@Entity
	public class TwoWheeler extends VehicleForInheritance {
		// Code Here
	}
	
3. Join
- To Overcome the cons of TablePerClass we use Join
- It make it more normalized tables and non repeated columns
- also for this type it's not required to give generation strategy as TABLE.. it accepts AUTO

	e.g.
	
	@Entity
	@Inheritance(strategy=InheritanceType.JOINED)
	public class VehicleForInheritance {
		@Id
		@GeneratedValue
		private int id;
		// Code Here
	}
	
	
CRUD Operation
----------------------------
1. Save or persist
2. Get or load - know the difference(http://www.mkyong.com/hibernate/different-between-session-get-and-session-load/)

- One more comment for GET vs LOAD in above blogs comment section

	Session.load() will return a proxy always and it will *not* throw the ObjectNotFoundException exception until later (on access). This is a key point missed in the discussion above. Because it does not throw the ObjectNotFoundException until it is accessed, it can make tracking errors harder.
	
	Session.get() will return the proxied object with one-level loaded (the fields for the object with the given identifier) plus cascading. If the object with the given ID does not exists, you will know right then because it will return null, not a proxy.
	
	The thing to keep in mind (imho) is when do you want to find out if the object with the given id exists or not? If you need to know right away, use get(). If it is OK to find out later, then use load().

3. SaveOrUpdate
4. delete


Hibernate Object state
---------------------
1. Transient   - before hibernate save, the object is in tansient state
2. Persistent  - after hiberante save (session.save() / saveOrUpdate()), the object is in persistent state till that session is not closed.
3. Detached    - After session is closed, object tuns into detahced.

	e.g. 
		 
		 ** Transient State */
		// At this moment the user object in transient state
		UserDetailsForCrud user = new UserDetailsForCrud();
		user.setName("Transient Data Name");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		//By using session.save() ... making user object from transient to persistent
		user.setName("Object before save");
		/**  Persistent State */
		session.save(user);
		
		// After saving an object it enters into persistent state. Therefore even after changing the object data, it will
		// reflected into database as it is in persistent state till the session is not closed.
		user.setName("Object After save");

		session.getTransaction().commit();
		session.close();
		
		/**  Detached State */
		// After the session is closed .. user object has Detached state
		user.setName("Object in detached state");
	
	
	
Hibernate HQL
---------------------
- By using createQuery method
	
	e.g.
	
	session.createQuery("from UserDetailsForQuery");
	
	- In that, the table name is nothing but a EntityName defined in pojo creation
	
	// while parameter binding use field name
	 
	session.createQuery("select name from UserDetailsForQuery");
	- In that, "name" is the field name in Entity it's not a column name in table.  

- By 2 ways we can bind the parameters and prevent SQL injection

	1. Position indicator : by using "?" operator
	
		e.g.
		Query query = session.createQuery("from UserDetailsForQuery where name = ?");
		query.setString(0, userName);
		
		// can define multiple "?" 
		Query query = session.createQuery("from UserDetailsForQuery where id = ? and name = ?");
		query.setString(0, userId);
		query.setString(1, userName);

	2. Place Holder [Recommended way] : by using ":<anyDefination>" e.g. ":name"
		
		e.g.
		Query query = session.createQuery("from UserDetailsForQuery where name = :userName");
		query.setString("userName", userName);
	
Hibernate Named Queries
-----------------------

Two ways 

- @NamedQuery / @NamedQueries (for defining multiple named query in it) : Used to write HQL queries only
	
		syntax - @NamedQuery(name="<Query Name>", query = "<HQL Query>")
	
		e.g.
		 
		@NamedQuery(name="UserDetails.byName", query = "from UserDetailsForQuery where name = ?")
		
		can define multiple named query using @NamedQueries
		
		@NamedQueries(
			{
				@NamedQuery(name="UserDetails.byName", query = "from UserDetailsForQuery where name = ?"),
				@NamedQuery(name="UserDetails.byNoCondition", query = "from UserDetailsForQuery")
			}
		)
	
- @NamedNativeQuery / @NamedNativeQuries  : Used to write plain SQL queries 

		syntax - @NamedNativeQuery(name="<Query Name>", query = "<HQL Query>", resultClass=<Expectedclass>)
	
		e.g.
		 
		@NamedNativeQuery(name = "UserDetails.byId", query = "select * from User_Details_For_Query where id = ?", resultClass=UserDetailsForQuery.class)


Both Queries can be executed as,
	
		session.getNamedQuery("<Query Name defined in annotation>");
		
		e.g.
		
		session.getNamedQuery("UserDetails.byName");
		session.getNamedQuery("UserDetails.byId");
		
Hibernate Criteria Query
----------------------

For multiple disjunction ('OR') - http://stackoverflow.com/questions/5859058/how-to-make-a-criteria-query-with-3-or-criterions-properly
