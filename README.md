# Persistence_Serialization_JDBC

CS 4311 Software Engineering II: Ex6a Persistence with JDBC
===========================================================

Introduction:

This exercise illustrates Observable and Persistent Patterns:

Observable: Observers (in this case GUIs) register themselves to an Observable
(in this case a Supplier entity/record). When the data in the Supplier 
changes (mutates), then the Observers are notified to refresh, e.g. update
the screen display.

Persistent: An up-to-date copy of the data in a memory object is kept on disk.
If the application closes, and then restarts, the disk data is reloaded to memory.

Ex6a: Observable with Persistence using JDBC.
Reading: Pages 60-61, 73-85.

Ex6b: Observable with Persistence using Serialization provided by Java.
Reading: Pages 62, 86-87.
