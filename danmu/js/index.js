var bulletChat = {
    data:{
        content:['第一','第二','第三','第四','第五','第六'],
        color:[ '#0099CC','#333333', '#009966','#FFFF66','#9933FF','#FFFF99','#CCCCFF','#CC9933','#FFFF66'],
    },
    init: function(){
        
        var h = setHeight();
        $(window).resize(function(){
            h=setHeight();
        });
        $('#submit').click(function(){
            bulletChat.submit(h);
            $('#input').value()='';
        });
        for(var i = 0;i < bulletChat.data.content.length;i++){
            bulletChat.scroll(h,i);
        }
    },
    scroll:function(h,i) {
        var content = $('#content');
        var height = parseInt(Math.random()*h+20);
        var width = window.innerWidth+parseInt(Math.random()*1000);
        var span = "<a class='bulletChat' style='width=100px;margin-left:"+width+"px;color:"+bulletChat.data.color[parseInt(Math.random()*8)]+";margin-top:"+height+"px;display:block;position:absolute;'>";
        span+=bulletChat.data.content[i];
        span+="</a>";
        content.append(span);
    },
    submit:function(h){
        var input=$('#input');
        bulletChat.data.content.push(input.val());
        bulletChat.scroll(h,bulletChat.data.content.length-1);
    }
}
function setHeight() {
    var content = $('#content');
    var height = window.innerHeight;
    height -= 100;
    content.css('height',height+'px');
    return height;
}