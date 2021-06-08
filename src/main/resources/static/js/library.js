$(document).ready(function() {
	var ch = $('body').height();
	var w = ch * 0.2;
	var imgH = w * 0.8;
	var tDh = $('.library-item').height();
	var tPh = tDh * 0.1;
	$('.library-element-container').css({ 'height': w + 'px' });
	$('.library-item-img').css({'height':imgH + 'px' });
	$('.library-item-text').css({'font-size': tPh + 'px'});
	$('.list-images').css({'max-height': w + 'px'});
	console.log("Div Height: " + w + "px");
	console.log("Img Height: " + imgH + "px");
	console.log("Font Size: " + tPh + "px");
});