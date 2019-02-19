To `serialize` an object means to convert its state to a byte stream so that the byte stream can be reverted back into a copy of the object.
A Java object is serializable if its class or any of its superclasses implements either the java.io.Serializable interface or its subinterface,
java.io.Externalizable.




`Node 1` **->** `Object` **->** `Serialized` **->** `Network`  **->** `Deserialized` **->** `Object` **->** `Node 2`

**Note:** Serializable is a [marker interface](https://github.com/mnp014/Java/blob/master/Marker%20Interface%20%20%20%20%20%20%20.md) that adds serializable behaviour to the class implementing it.
