### STEP 1:

Go to URL in your browser:  
`firefox` - click on HTTPS certificate chain (the lock icon right next to URL address).  
            Click "more info" > "security" > "show certificate" > "details" > "export..".  
            Pickup the name and choose file type example.cer  
            
`chrome` - click on site icon left to address in address bar,
           select "Certificate" -> "Details" -> "Export" and 
           save in format `Der-encoded binary, single certificate`.

### STEP 2:   
Now you have file with keystore and you have to add it to your JVM.  
 Determine location of cacerts files, eg. ```C:\Program Files (x86)\Java\jre1.6.0_22\lib\security\cacerts.```   

### STEP 3:   
Import the example.cer file into cacerts in command line (may need administrator command prompt):

```
./keytool.exe -import -alias <some_alias> -keystore  "C:\Program Files\Java\jdk-11.0.14\lib\security\cacerts" -file </path_of_cert/example.cer>
```

### STEP 4:   
Default password is `changeit`  

### STEP 5:   
Answer `YES` to the question `Trust this certificate?`    

### STEP 6:   
Restart your JVM/PC.

________________________
                  OR   
_________________________
### STEP 1:  
Import the root certificate.  

Execute the command  
```
   JRE_HOME/bin/keytool  -import  -trustcacerts
                         -alias certAlias  -file certFile
                         -keystore trustStoreFile
```
where:  
 - `certFile` is the file containing the root certificate,  
 - `certAlias` is the alias representing the certificate,  
 - `trustStoreFile` is the file containing your trust store.  

### STEP 2:  
Confirm that you trust the certificate.  

### STEP 3:  
default is `changeit`  

### STEP 4:  
Answer `YES` to the question Trust this certificate?  

Identify the trust store to the client application.  

In the command that launches the client application, use the -D option to specify the following properties:  
```
   javax.net.ssl.trustStore=trustStoreFile  
   javax.net.ssl.trustStorePassword=trustStorePassword  
```   
