# practice
Practice code, mostly similar to coding challenges.

# Tags
First lines of each code file will contain some metadata, tags etc. info

## Tags
level0: must revise before interviews


# Runnig Unit tests

Unit Tests:
# Run one class
mvn -q test -Dtest=classname
# Run one class method
mvn -q test -Dtest=LRUCacheTest#testFake

Run one main class (Only after this is compiled)
mvn -q exec:java -Dexec.mainClass="com.practice.warmup.JavaHashMap"