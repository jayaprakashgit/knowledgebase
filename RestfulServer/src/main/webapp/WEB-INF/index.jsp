html>
<body>
    <h1>JAX-RS Upload Form</h1>
 
    <form action="http://localhost:8081/RestfulServer/rest/upload/uploadFile/" method="post" enctype="multipart/form-data">
 
       <p>
        Select a file : <input type="file" name="uploadedFile" size="50" />
       </p>
       <p>
       The Next file : <input type="file" name="uploadedFile2" size="50" />
       </p>
 
       <input type="submit" value="Upload It" />
    </form>
 
</body>
</html>