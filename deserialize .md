The reverse process of creating object from sequence of bytes is called `deserialization`. <br/>
A class must implement Serializable interface present in `java.io` package in order to serialize its object successfully. <br/>
Serializable is a [marker interface](https://github.com/mnp014/Java/blob/master/Marker%20Interface%20%20%20%20%20%20%20.md) that adds serializable behaviour to the class implementing it.

`Node 1` *->* `Object` *->* `Serialized` *->* `Network`  *->* `Deserialized` *->* `Object` *->* `Node 2`
