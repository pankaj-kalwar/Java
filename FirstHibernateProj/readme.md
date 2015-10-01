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
 
------------------------------------------------------
 