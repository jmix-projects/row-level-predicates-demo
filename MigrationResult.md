This Jmix project was imported from the 'helpcuba2jmix' CUBA project.

### Migration result

* User entity was modified according to existing table.
* Data Stores were copied into Jmix configurations.
* Java/Kotlin classes were copied into single module with original packages. Some annotations and imports were modified according to Jmix libraries.
* Localization messages were copied into the single resource bundle.
* `views.xml` file was converted to `fetchPlans.xml` file and saved to resources.
* Menu items were copied into Jmix menu configuration file.
* REST properties were copied to `application.properties`.
* Screen descriptors were copied into resources root with original paths. XSD was changed, some elements and attributes were renamed accordingly.  
          
### What needs to be done manually

* Fix compilation errors in Java/Kotlin classes.
* Fix screen descriptors.    

See more information about migration in the [documentation](https://docs.jmix.io/jmix/cuba/index.html).