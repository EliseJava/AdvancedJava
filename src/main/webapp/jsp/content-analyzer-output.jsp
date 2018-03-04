<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<div id="content">
<div class="container">

  <h2>File Ripper Reader Report Menu</h2><br>
  <p><a href="displayUpload">Upload another file   </a>   ***   <a href='/java112'>Back to homepage</a></p><br>

  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#menu1">Summary</a></li>
    <li><a data-toggle="tab" href="#menu2">Token Count</a></li>
    <li><a data-toggle="tab" href="#menu3">Token Size</a></li>
    <li><a data-toggle="tab" href="#menu4">Unique Tokens</a></li>
    <li><a data-toggle="tab" href="#menu5">Big Words</a></li>
    <li><a data-toggle="tab" href="#menu6">Keyword Locations</a></li>
  </ul>

  <div class="tab-content">

    <div id="menu1" style="height:400px; width:850px; overflow-y: scroll;" class="tab-pane fade in active">
      <h5>Summary Report</h5>
      <p><pre><c:import url="${SumFilePath}" /></pre></p>
    </div>
    <div id="menu2" style="height:400px; width:850px; overflow-y: scroll;;" class="tab-pane fade">
      <h5>Token Count Report - A count of each unique token in the file</h5>
      <p><pre><c:import url="${CountFilePath}" /></pre></p>
    </div>
    <div id="menu3" style="height:400px; width:850px; overflow-y: scroll;" class="tab-pane fade">
      <h5>Token Size Report - Unique sizes and a Histogram presentation </h5>
      <p><pre><c:import url="${SizeFilePath}" /></pre></p>
    </div>
    <div id="menu4" style="height:400px; width:850px; overflow-y: scroll;" class="tab-pane fade">
      <h5>Unique Tokens Report - List of all the unique tokens in the file</h5>
      <p><pre><c:import url="${UniqueFilePath}" /></pre></p>
    </div>
    <div id="menu5" style="height:400px; width:850px; overflow-y: scroll;" class="tab-pane fade">
      <h5>Big Words Report - List all big words. The lenth is specified in the keyword.txt</h5>
      <p><pre><c:import url="${BigFilePath}" /></pre></p>
    </div>
    <div id="menu6" style="height:400px; width:850px; overflow-y: scroll;" class="tab-pane fade">
      <h5>Keyword Location Report - Lists the location of keywords in the file</h5>
      <p><pre><c:import url="${KeyFilePath}" /></pre></p>
    </div>
  </div>
</div>
</div>



