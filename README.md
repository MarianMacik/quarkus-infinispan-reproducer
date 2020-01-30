# quarkus-infinispan-reproducer

This project uses Quarkus, the Supersonic Subatomic Java Framework.



## Running the reproducer

1. Run the build of the application:

   ``` 
   ./mvnw clean install
   ```

   Tests will pass.

2. Now comment the quarkus-infinispan-client dependency in pom.xml:

   ```xml
   <!--<dependency>
     <groupId>io.quarkus</groupId>
     <artifactId>quarkus-infinispan-client</artifactId>
   </dependency>-->
   ```

   And run the command:

   ``` 
   ./mvnw clean install -Ppersistence
   ```

   Tests will fail with `javax.enterprise.inject.UnsatisfiedResolutionException`
   
3. You can even explore dependency trees in the root of the application:

   * depTree.txt - the one from the first step of the guide
   
   * depTreeWithPersistence.txt - the one from the second step with `-Ppersistence` profile activated.
   
   They are the same:
   
   ```shell script
      $ diff depTree*
      182,183c182,183
      < [INFO] Total time:  1.521 s
      < [INFO] Finished at: 2020-01-30T12:25:33+01:00
      ---
      > [INFO] Total time:  1.649 s
      > [INFO] Finished at: 2020-01-30T12:25:22+01:00
      $
   
   ```
