$(document).ready(function(){
    /* 슬라이드 */
    var i = 0;
    function slideShow(){
        i++;
        if(i>$("#mainSlideBox li:last").index()){
            i=0;
        }
        $("#mainSlideBox li").eq(i).stop().fadeIn("slow");
        $("#mainSlideBox li").eq(i-1).stop().fadeOut("slow");
    }
    setInterval(slideShow,4000);//4초마다
    
    
    
});