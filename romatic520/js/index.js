function setHW(){
  var height = $(window).height() - 800;
  var width = $(window).width() - 800;
  height = height/2;
  width = width/2;
  if(height < 0 || width < 0){
      return;
  }
  var show = $(".rightMapper");
  show.css("left",width+"px");
  show.css("top",height+"px")
}

$(document).ready(function() {
  setHW();
  $(window).resize(function() {
    setHW();
});
});