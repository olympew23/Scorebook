/**
 * Created by jerieshasmith on 4/19/17.
 */
var canvas;
var context;
var canvasWidth = 1000;
var canvasHeight = 600;
var padding = 25;
var lineWidth = 8;
var colorPurple = "#cb3594";
var colorGreen = "#659b41";
var colorYellow = "#ffcf33";
var colorBrown = "#986928";
var outlineImage = new Image();
var crayonImage = new Image();
var markerImage = new Image();
var eraserImage = new Image();
var crayonBackgroundImage = new Image();
var markerBackgroundImage = new Image();
var eraserBackgroundImage = new Image();
var crayonTextureImage = new Image();
var clickX = new Array();
var clickY = new Array();
var clickColor = new Array();
var clickTool = new Array();
var clickSize = new Array();
var clickDrag = new Array();
var paint = false;
var curColor = colorPurple;
var curTool = "crayon";
var curSize = "normal";
var mediumStartX = 18;
var mediumStartY = 19;
var mediumImageWidth = 93;
var mediumImageHeight = 46;
var drawingAreaX = 250;
var drawingAreaY = 100;
var drawingAreaWidth = 510;
var drawingAreaHeight = 425;
var toolHotspotStartY = 23;
var toolHotspotHeight = 38;
var sizeHotspotStartY = 157;
var sizeHotspotHeight = 36;
var sizeHotspotWidthObject = new Object();
sizeHotspotWidthObject.huge = 39;
sizeHotspotWidthObject.large = 25;
sizeHotspotWidthObject.normal = 18;
sizeHotspotWidthObject.small = 16;
var totalLoadResources = 3;
var curLoadResNum = 0;
//var url = canvas.toDataUrl('image/png');
/**
 * Calls the redraw function after all neccessary resources are loaded.
 */
function resourceLoaded()
{
    if(++curLoadResNum >= totalLoadResources){
        redraw();
    }
}

/**
 * Creates a canvas element, loads images, adds events, and draws the canvas for the first time.
 */
function prepareCanvas()
{
    // Create the canvas (Neccessary for IE because it doesn't know what a canvas element is)
    var canvasDiv = document.getElementById('canvasDiv');
    canvas = document.createElement('canvas');
    canvas.setAttribute('width', canvasWidth);
    canvas.setAttribute('height', canvasHeight);
    canvas.setAttribute('id', 'canvas');
    canvas.setAttribute('onchange','updateCanvasValue();')
    canvasDiv.appendChild(canvas);

    if(typeof G_vmlCanvasManager != 'undefined') {
        canvas = G_vmlCanvasManager.initElement(canvas);
    }
    context = canvas.getContext("2d"); // Grab the 2d canvas context
    // Note: The above code is a workaround for IE 8 and lower. Otherwise we could have used:
//	     context = document.getElementById('canvas').getContext("2d");

    // Load images
    // -----------

    outlineImage.onload = function() { resourceLoaded();
    };
    outlineImage.src = "download.svg";

    eraserImage.onload = function() { resourceLoaded();
    };
    eraserImage.src = "eraser-outline.png";

    eraserBackgroundImage.onload = function() { resourceLoaded();
    };
    eraserBackgroundImage.src = "eraser-background.png";

    // THIS needs to be an SVG (Extension does not matter, just the fact that it is an SVG


//Mouse Down Event
    $('#canvas').mousedown(function(e){
        var mouseX = e.pageX - this.offsetLeft;
        var mouseY = e.pageY - this.offsetTop;

//  paint = true;
//  addClick(e.pageX - this.offsetLeft, e.pageY - this.offsetTop);
//  redraw();
        paint = true;
        addClick(mouseX, mouseY, false);
        redraw();

    });

//Mouse move event


    $('#canvas').mousemove(function(e){
        if(paint==true){
            addClick(e.pageX - this.offsetLeft, e.pageY - this.offsetTop, true);
            redraw();
        }
    });

    $('#canvas').mouseup(function(e){
        paint = false;
        redraw();
    });

    $('#canvas').mouseleave(function(e){
        paint = false;
    });


// Add click
    var clickX = new Array();
    var clickY = new Array();
    var clickDrag = new Array();
    var paint;




}
//function addClick(x, y, dragging)
//{
//  clickX.push(x);
//  clickY.push(y);
//  clickDrag.push(dragging);
//}
function addClick(x, y, dragging)
{
    clickX.push(x);
    clickY.push(y);
    clickTool.push(curTool);
    clickColor.push(curColor);
    clickSize.push(curSize);
    clickDrag.push(dragging);
}

function clearCanvas()
{
    context.clearRect(0, 0, canvasWidth, canvasHeight);
}



function updateCanvasValueAndSubmit() {
    alert('updatedCanvasValue defined');
    elem = document.getElementById("canvas");

    document.getElementById("updatedCanvas").value = elem.toDataURL();

    console.log(elem.toDataURL());

    document.forms["saveCanvasForm"].submit();

    return true;

}




// redraw
//redraw()


function redraw(){
    context.clearRect(0, 0, context.canvas.width, context.canvas.height); // Clears the canvas
    context.strokeStyle = "#df4b26";
    context.lineJoin = "round";
    context.lineWidth = 5;





    for(var i=0; i < clickX.length; i++) {
        context.beginPath();
        if(clickDrag[i] && i){
            context.moveTo(clickX[i-1], clickY[i-1]);
        }else{
            context.moveTo(clickX[i]-1, clickY[i]);
        }
        context.lineTo(clickX[i], clickY[i]);
        context.closePath();
        context.stroke();
    }

    if(curTool == "eraser")
    {
        context.drawImage(eraserBackgroundImage, 0, 0, canvasWidth, canvasHeight);
        context.drawImage(eraserImage, 18, 19, mediumImageWidth, mediumImageHeight);
    }
    if(clickTool[i] == "eraser"){
        //context.globalCompositeOperation = "destination-out"; // To erase instead of draw over with white
        context.strokeStyle = 'white';
    }
    context.save();
    context.beginPath();
    context.rect(drawingAreaX, drawingAreaY, drawingAreaWidth, drawingAreaHeight);
    context.clip();
    context.drawImage(crayonTextureImage, 0, 0, canvasWidth, canvasHeight);
    context.drawImage(outlineImage, drawingAreaX, drawingAreaY, drawingAreaWidth, drawingAreaHeight);
}

$(function() {
    var width = "+=" + $(window).width();

    $("#animate").animate({
            left: width
        }, 5000, function() {
            $("#animate").css("display", "none");
        });
});
$(function() {
    var img = $("#baseball"),
        width = img.width,
        screenWidth = $(window).width(),
        duration = 5500;

    function animateBaseball() {
       img.css().animate({
            "left": screenWidth
        }, duration, animateBaseball);
    }

    animateBaseball();

});



$(function() {
    var img = $("#fire"),
        width = img.get(0).width,
        screenWidth = $(window).width(),
        duration = 5000;

    function animateFire() {
        img.css().animate({
            "left": screenWidth
        }, duration, animateFire);
    }

    animateFire();
});

//     var b = function ($b, speed) {
//         ballsWidth = $b.width();
//
//         $b.animate({
//             "left": "100%"
//         }, speed);
//     };
//
//     $(function () {
//         b($("#b"), 5000);
//     });





