// IStringConcat.aidl
package com.example.boundserviceexample;

// Declare any non-default types here with import statements

interface IStringConcat{
    String concat(in List<String> items);
}