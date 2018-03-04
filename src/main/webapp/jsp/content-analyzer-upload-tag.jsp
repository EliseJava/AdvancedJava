<div id="content">
    <h2>File Ripper Reader Application<span class="post-span"> by Elise Strauss</span></h2>

    <p><a href='/java112'>Back to homepage</a></p>

    <h4>Select a file to be analyzed</h4>

    <form method="POST" action="upload" enctype="multipart/form-data" >
      File:
      <input type="file" name="file" id="file" />
      <br><br>
      Destination:
      <input type="text" value="/tmp" name="destination"/>
      <br><br>
      <input type="submit" value="Upload" name="upload" id="upload" />
</form>

</div>
