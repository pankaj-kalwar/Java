Hibernate Annotation Descriptions
--------------------------------------------------
------------------------------------------------------


@Entity(name="Table") vs @Entity @Table(name="Table")
--------------------------------------------------------
@Entity(name="Table") - It overrides the default entity with this name i.e If my class name is TableDetails than it overrides the entity name with Table as well as the table name in DB

 @Entity
 @Table(name="Table") -  It only overrides the Table name for DB not the entity name i.e. you can simply use the class name for you HQL queries
 
------------------------------------------------------
 
Some Important Annotations
--------------------------------------------------
 
 @Basic - just to define the fethc type or make filed optional
 
 @Transient - Making Field non persistent
 
 @Temporal - Used to define the date either in date/time/both(i.e. Timestamp [default])
 e.g. 
 	1. @Temporal(TemoralType.DATE)
 	2. @Temporal(TemoralType.TIME)
 	3. @Temporal(TemoralType.TIMESTAMP)
 	
 @Lob - Used to define a field as a large object, i.e. the output column size in a table is more than 255 character 
 
 @GeneratedValue - Used to define the primary key 
 	e.g. 
 		@GeneratedValue(strategy=GenerationType.AUTO)
 	
 		Strategy Types
 	
	 	1. AUTO - Automatically choose the identity, sequence  or table based on the db
	 	2. IDENTITY - 
	 	3. SEQUENCE - Creating a new hibernate_sequence than calling next value and than insert ids 
	 	4. TABLE - Fetch sequence from sequence table than update current sequence and than add it to 						your table

 
------------------------------------------------------
 