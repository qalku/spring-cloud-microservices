/*
var touching = null;
$('selector').each(function() {
    this.addEventListener("touchstart", function(e) {
        e.preventDefault();
        touching = window.setTimeout(longTouch, 500, true);
    }, false);
    this.addEventListener("touchend", function(e) {
        e.preventDefault();
        window.clearTimeout(touching);
    }, false);
});

function longTouch(e) {
    // do something!
}
*/

    var obiekt="xx";
    var up=0;
    var zamykanie=1;

    function setZnakKlaw_DWA(znak){
        obiekt="ilka";
        var akt=document.getElementById(""+obiekt).value;
        if(znak=='BACK'){
            document.getElementById(""+obiekt).value="";
                    c=akt.length;
                    for(i=0;i<(c-1);i++){
                        document.getElementById(""+obiekt).value=document.getElementById(""+obiekt).value+akt[i];
                    }
                    try{ cofacz();
                    }catch(e){}
        }else if(znak=='UP'){
        }else if(znak=='DOWN'){
        }else if(znak=='ABC'){
            Android.setKasaStatus(6);
        }else if(znak=='~'){
        }else if(znak=='SPACJA'){
        }else if(znak=='HUM'){
        }else if(znak=='TOOL'){
        }else if(znak=='PLUS'){
            zakonczLiczenieTowaru(0);
        }else if(znak=='%'){
            document.getElementById(""+obiekt).value="";
            cofaczC();
        }else if(znak=='GOTOWE'){
            if(akt<0.001){ akt=1; }
            gotowePodliczenie(obiekt,akt);
            document.getElementById(""+obiekt).value="";
        }else{
            document.getElementById(""+obiekt).value=akt+znak;
            //cofacz();
            barkacz();
        }

    }

    function setZnakKlaw(znak){
        var akt=document.getElementById(""+obiekt).value;

        if(znak=='BACK'){
            document.getElementById(""+obiekt).value="";
            c=akt.length;
            for(i=0;i<(c-1);i++){
                document.getElementById(""+obiekt).value=document.getElementById(""+obiekt).value+akt[i];
            }
            try{ cofacz();
            }catch(e){}
        }else if(znak=='UP'){
            klawiaturaUP();
        }else if(znak=='DOWN'){
            klawiaturaDOWN();
        }else if(znak=='ABC'){
            klawiaturaDOWN();
        }else if(znak=='~'){
            klawiaturaNUMERIC();
        }else if(znak=='SPACJA'){
            document.getElementById(""+obiekt).value=akt+" ";
        }else if(znak=='HUM'){
            klawiaturaHUM();
        }else if(znak=='TOOL'){
        }else if(znak=='GOTOWE'){
            if(zamykanie>0){ clickCloseKlaw(); }
            try{
                gotowe(obiekt,akt);
            }catch(e){
            }
        }else{
            document.getElementById(""+obiekt).value=akt+znak;
        }


        if(obiekt=="nip"){
            akt=document.getElementById(""+obiekt).value;
            Android.log("KEY KLAW - "+obiekt+", LENGTH: "+akt.length+", VAL: "+akt );
            var ile=akt.length;
            if(ile==10){
                Android.log("KEy - OK");
                try{
                    gotowe(obiekt,akt);
                }catch(e){}
            }
        }
    }

    function klawiaturaStart(ob){
        obiekt=ob;
        klawiaturaDOWN();
        $("#klawiatura").slideDown("", function () {

        });
    }
    function klawiaturaStart(ob, typ){
            obiekt=ob;
            if(typ=="UP"){
                klawiaturaUP();
            }else if(typ=="HUM"){
                klawiaturaHUM();
            }else if(typ=="NUM"){
                klawiaturaNUMERIC();
            }else{
                klawiaturaDOWN();
            }
            $("#klawiatura").slideDown("", function () {

            });
            try{
                $("#klawiaturaBack").slideDown("", function () { });
            }catch(e){}
    }

    function klawiaturaStartA(ob, typ, zam){
        zamykanie=zam;
        klawiaturaStart(ob, typ);
    }

    function klawiaturaDOWN(){
    var txt='<div style="text-align:center;">\n\
        <table cellspacing=0 width=100%>\n\
            <tr>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(1);">1</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(2);">2</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(3);">3</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(4);">4</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(5);">5</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(6);">6</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(7);">7</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(8);">8</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(9);">9</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(0);">0</div></td>\n\
            </tr>\n\
        </table>\n\
        <table cellspacing=0 width=100%>\n\
            <tr>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'q\');">q</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'w\');">w</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'e\');">e</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'r\');">r</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'t\');">t</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'y\');">y</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'u\');">u</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'i\');">i</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'o\');">o</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'p\');">p</div></td>\n\
            </tr>\n\
        </table>\n\
        <table cellspacing=0 width=100%>\n\
            <tr>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'a\');">a</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'s\');">s</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'d\');">d</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'f\');">f</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'g\');">g</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'h\');">h</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'j\');">j</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'k\');">k</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'l\');">l</div></td>\n\
            </tr>\n\
        </table>\n\
        <table cellspacing=0 width=100%>\n\
            <tr>\n\
                <td><div class="przyciskUP" onClick="clickerObj(this);setZnakKlaw(\'UP\');"><img src="./images/keyup.png" height=20></div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'z\');">z</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'x\');">x</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'c\');">c</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'v\');">v</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'b\');">b</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'n\');">n</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'m\');">m</div></td>\n\
                <td><div class="przyciskUP" onClick="clickerObj(this);setZnakKlaw(\'BACK\');"><img src="./images/backspace_white.png" height=20></div></td>\n\
            </tr>\n\
        </table>\n\
        <table cellspacing=0 width=100%>\n\
            <tr>\n\
                <td><div id="spx4" class="przyciskUP" onClick="clickerObj(this);setZnakKlaw(\'HUM\');" style="min-height:28px;">@1#</div></td>\n\
                <td><div id="spx3" class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'TOOL\');" style="min-width:28px;min-height:28px;">TOOL</div></td>\n\
                <td><div id="spx0" class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\',\');" style="min-width:25px;min-height:28px;">,</div></td>\n\
                <td width=100%><div id="spx1" class="przyciskUP" onClick="clickerObj(this);setZnakKlaw(\'SPACJA\');" style="min-height:28px;width:100%;">SPACJA</div></td>\n\
                <td><div id="spx2" class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'.\');" style="min-width:25px;min-height:28px;">.</div></td>\n\
                <td><div id="spx5" class="przyciskUP" onClick="clickerObj(this);setZnakKlaw(\'GOTOWE\');"style="min-width:45px;min-height:28px;"><img src="./images/enter.png" height=28></div></td>\n\
            </tr>\n\
        </table>\n\
        </div>';
        document.getElementById("klawiaturaContent").innerHTML=txt;
        var tablet=Android.isTablet();
        if(tablet>0){
            document.getElementById("spx4").style.width="130px";
            document.getElementById("spx3").style.width="100px";
            document.getElementById("spx0").style.width="100px";
            document.getElementById("spx1").style.width="100%";
            document.getElementById("spx2").style.width="110px";
            document.getElementById("spx5").style.width="130px";
        }
    }

    function klawiaturaUP(){
    var txt='<div style="text-align:center;">\n\
        <table cellspacing=0 width=100%>\n\
            <tr>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(1);">1</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(2);">2</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(3);">3</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(4);">4</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(5);">5</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(6);">6</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(7);">7</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(8);">8</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(9);">9</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(0);">0</div></td>\n\
            </tr>\n\
        </table>\n\
        <table cellspacing=0 width=100%>\n\
            <tr>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'Q\');">Q</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'W\');">W</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'E\');">E</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'R\');">R</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'T\');">T</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'Y\');">Y</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'U\');">U</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'I\');">I</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'O\');">O</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'P\');">P</div></td>\n\
            </tr>\n\
        </table>\n\
        <table cellspacing=0 width=100%>\n\
            <tr>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'A\');">A</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'S\');">S</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'D\');">D</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'F\');">F</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'G\');">G</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'H\');">H</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'J\');">J</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'K\');">K</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'L\');">L</div></td>\n\
            </tr>\n\
        </table>\n\
        <table cellspacing=0 width=100%>\n\
            <tr>\n\
                <td><div class="przyciskUP" onClick="clickerObj(this);setZnakKlaw(\'DOWN\');"><img src="./images/keydown.png" height=20></div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'Z\');">Z</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'X\');">X</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'C\');">C</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'V\');">V</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'B\');">B</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'N\');">N</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'M\');">M</div></td>\n\
                <td><div class="przyciskUP" onClick="clickerObj(this);setZnakKlaw(\'BACK\');"><img src="./images/backspace_white.png" height=20></div></td>\n\
            </tr>\n\
        </table>\n\
        <table cellspacing=0 width=100%>\n\
            <tr>\n\
                <td><div id="spx4" class="przyciskUP" onClick="clickerObj(this);setZnakKlaw(\'HUM\');" style="min-height:28px;">@1#</div></td>\n\
                <td><div id="spx3" class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'TOOL\');" style="min-width:25px;min-height:28px;">TOOL</div></td>\n\
                <td><div id="spx0" class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\',\');" style="min-width:25px;min-height:28px;">,</div></td>\n\
                <td width=100%><div id="spx1" class="przyciskUP" onClick="clickerObj(this);setZnakKlaw(\'SPACJA\');" style="min-height:28px;width:100%;">SPACJA</div></td>\n\
                <td><div id="spx2" class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'.\');" style="min-width:25px;min-height:28px;">.</div></td>\n\
                <td><div id="spx5" class="przyciskUP" onClick="clickerObj(this);setZnakKlaw(\'GOTOWE\');" style="min-height:28px;min-width:45px;"><img src="./images/enter.png" height=28></div></td>\n\
            </tr>\n\
        </table>\n\
        </div>';
        document.getElementById("klawiaturaContent").innerHTML=txt;
        var tablet=Android.isTablet();
        if(tablet>0){
            document.getElementById("spx4").style.width="130px";
            document.getElementById("spx3").style.width="100px";
            document.getElementById("spx0").style.width="100px";
            document.getElementById("spx1").style.width="100%";
            document.getElementById("spx2").style.width="110px";
            document.getElementById("spx5").style.width="130px";
        }
    }

    function klawiaturaHUM(){

    var txt='<div style="text-align:center;">\n\
        <table cellspacing=0 width=100%>\n\
            <tr>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(1);">1</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(2);">2</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(3);">3</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(4);">4</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(5);">5</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(6);">6</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(7);">7</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(8);">8</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(9);">9</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(0);">0</div></td>\n\
            </tr>\n\
        </table>\n\
        <table cellspacing=0 width=100%>\n\
            <tr>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'@\');">@</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'#\');">#</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'$\');">$</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'_\');">_</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'&\');">&</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'-\');">-</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'+\');">+</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'(\');">(</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\')\');">)</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'/\');">/</div></td>\n\
            </tr>\n\
        </table>\n\
        <table cellspacing=0 width=100%>\n\
            <tr>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'=\');">=\<</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'*\');">*</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'"\');">"</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'\');">\'</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\':\');">:</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\';\');">;</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'!\');">!</div></td>\n\
                <td><div class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'?\');">?</div></td>\n\
                <td><div class="przyciskKl" onClick=clickerObj(this);"setZnakKlaw(\'BACK\');"><img src="./images/backspace_white.png" height=20></div></td>\n\
            </tr>\n\
        </table>\n\
        <table cellspacing=0 width=100%>\n\
            <tr>\n\
                <td><div id="spx4" class="przyciskUP" onClick="clickerObj(this);setZnakKlaw(\'ABC\');" style="min-width:28px;min-height:28px;">ABC</div></td>\n\
                <td><div id="spx3" class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\',\');" style="min-width:25px;min-height:28px;">,</div></td>\n\
                <td><div id="spx0" class="przyciskUP" onClick="clickerObj(this);setZnakKlaw(\'~\');" style="min-width:28px;min-height:28px;">1234</div></td>\n\
                <td width=100%><div id="spx1" class="przyciskUP" onClick="clickerObj(this);setZnakKlaw(\'SPACJA\');" style="min-height:28px;width:100%;">SPACJA</div></td>\n\
                <td><div id="spx2" class="przyciskKl" onClick="clickerObj(this);setZnakKlaw(\'.\');" style="min-width:25px;min-height:28px;">.</div></td>\n\
                <td><div id="spx5" class="przyciskUP" onClick="clickerObj(this);setZnakKlaw(\'GOTOWE\');" style="min-height:28px;min-width:45px;"><img src="./images/enter.png" height=28></div></td>\n\
            </tr>\n\
        </table>\n\
        </div>';

        document.getElementById("klawiaturaContent").innerHTML=txt;
        var tablet=Android.isTablet();
        if(tablet>0){
              document.getElementById("spx4").style.width="130px";
              document.getElementById("spx3").style.width="100px";
              document.getElementById("spx0").style.width="100px";
              document.getElementById("spx1").style.width="100%";
              document.getElementById("spx2").style.width="110px";
              document.getElementById("spx5").style.width="130px";
        }

    }

    function klawiaturaNUMERIC(){
    var txt='<div style="text-align:center;">\n\
        <table cellspacing=0 width=100%>\n\
            <tr>\n\
                <td width=30><div class="przyciskKl" style="height:33px;width:40px;" onClick="clickerObj(this);setZnakKlaw(\'+\');">+</div></td>\n\
                <td width=25%><div class="przyciskKl" style="height:33px;" onClick="clickerObj(this);setZnakKlaw(\'1\');">1</div></td>\n\
                <td width=25%><div class="przyciskKl" style="height:33px;" onClick="clickerObj(this);setZnakKlaw(\'2\');">2</div></td>\n\
                <td width=25%><div class="przyciskKl" style="height:33px;" onClick="clickerObj(this);setZnakKlaw(\'3\');">3</div></td>\n\
                <td width=25%><div class="przyciskKl" style="height:33px;" onClick="clickerObj(this);setZnakKlaw(\'%\');">%</div></td>\n\
             </tr>\n\
             <tr>\n\
                <td><div class="przyciskKl" style="height:33px;" onClick="clickerObj(this);setZnakKlaw(\'-\');">-</div></td>\n\
                <td><div class="przyciskKl" style="height:33px;" onClick="clickerObj(this);setZnakKlaw(\'4\');">4</div></td>\n\
                <td><div class="przyciskKl" style="height:33px;" onClick="clickerObj(this);setZnakKlaw(\'5\');">5</div></td>\n\
                <td><div class="przyciskKl" style="height:33px;" onClick="clickerObj(this);setZnakKlaw(\'6\');">6</div></td>\n\
                <td><div class="przyciskKl" style="height:33px;" onClick="clickerObj(this);setZnakKlaw(\'SPACJA\');">_</div></td>\n\
             </tr>\n\
             <tr>\n\
                <td><div class="przyciskKl" style="height:33px;" onClick="clickerObj(this);setZnakKlaw(\'*\');">*</div></td>\n\
                <td><div class="przyciskKl" style="height:33px;" onClick="clickerObj(this);setZnakKlaw(\'7\');">7</div></td>\n\
                <td><div class="przyciskKl" style="height:33px;" onClick="clickerObj(this);setZnakKlaw(\'8\');">8</div></td>\n\
                <td><div class="przyciskKl" style="height:33px;" onClick="clickerObj(this);setZnakKlaw(\'9\');">9</div></td>\n\
                <td><div class="przyciskKl" style="height:33px;" onClick="clickerObj(this);setZnakKlaw(\'BACK\');"><img src="./images/backspace_white.png" height=20></div></td>\n\
             </tr>\n\
             <tr>\n\
                <td><div class="przyciskKl" style="height:33px;" onClick="clickerObj(this);setZnakKlaw(\'/\');" style="min-width:25px;min-height:28px;">/</div></td>\n\
                <td><div class="przyciskKl" style="height:33px;" onClick="clickerObj(this);setZnakKlaw(\'ABC\');" style="min-width:25px;min-height:28px;">ABC</div></td>\n\
                <td><div class="przyciskKl" style="height:33px;" onClick="clickerObj(this);setZnakKlaw(\'0\');" style="min-width:25px;min-height:28px;">0</div></td>\n\
                <td><div class="przyciskKl" style="height:33px;" onClick="clickerObj(this);setZnakKlaw(\'.\');" style="min-width:25px;min-height:28px;">.</div></td>\n\
                <td><div class="przyciskKl" style="height:33px;" onClick="clickerObj(this);setZnakKlaw(\'GOTOWE\');" style="min-height:28px;min-width:45px;"><img src="./images/enter.png" height=28></div></td>\n\
             </tr>\n\
        </table>\n\
        </div>';

        document.getElementById("klawiaturaContent").innerHTML=txt;
    }

    function klawiaturaNUMERIC_DWA(){
        var txt='<div style="text-align:center;">\n\
            <table cellspacing=0 width=100%>\n\
                <tr>\n\
                    <td width=30></td>\n\
                    <td width=25%><div class="przyciskKl" style="height:43px;font-weight:bold;font-size:28px;" onClick="clickerObj(this);setZnakKlaw_DWA(\'1\');">1</div></td>\n\
                    <td width=25%><div class="przyciskKl" style="height:43px;font-weight:bold;font-size:28px;" onClick="clickerObj(this);setZnakKlaw_DWA(\'2\');">2</div></td>\n\
                    <td width=25%><div class="przyciskKl" style="height:43px;font-weight:bold;font-size:28px;" onClick="clickerObj(this);setZnakKlaw_DWA(\'3\');">3</div></td>\n\
                    <td width=25%><div class="przyciskKl" style="height:43px;font-weight:bold;font-size:18px;" onClick="clickerObj(this);setZnakKlaw_DWA(\'%\');"><div style="background:red;border-radius:15px;padding:5px;margin:10px;">C</div></div></td>\n\
                 </tr>\n\
                 <tr>\n\
                    <td></td>\n\
                    <td><div class="przyciskKl" style="height:43px;font-weight:bold;font-size:28px;" onClick="clickerObj(this);setZnakKlaw_DWA(\'4\');">4</div></td>\n\
                    <td><div class="przyciskKl" style="height:43px;font-weight:bold;font-size:28px;" onClick="clickerObj(this);setZnakKlaw_DWA(\'5\');">5</div></td>\n\
                    <td><div class="przyciskKl" style="height:43px;font-weight:bold;font-size:28px;" onClick="clickerObj(this);setZnakKlaw_DWA(\'6\');">6</div></td>\n\
                    <td><div class="przyciskKl" style="height:43px;font-weight:bold;font-size:28px;" onClick="clickerObj(this);setZnakKlaw_DWA(\'BACK\');"><img src="./images/backspace_white.png" height=20></div></td>\n\
                 </tr>\n\
                 <tr>\n\
                    <td></td>\n\
                    <td><div class="przyciskKl" style="height:43px;font-weight:bold;font-size:28px;" onClick="clickerObj(this);setZnakKlaw_DWA(\'7\');">7</div></td>\n\
                    <td><div class="przyciskKl" style="height:43px;font-weight:bold;font-size:28px;" onClick="clickerObj(this);setZnakKlaw_DWA(\'8\');">8</div></td>\n\
                    <td><div class="przyciskKl" style="height:43px;font-weight:bold;font-size:28px;" onClick="clickerObj(this);setZnakKlaw_DWA(\'9\');">9</div></td>\n\
                    <td><div class="przyciskKl" style="height:43px;font-weight:bold;font-size:18px;background:orange;" onClick="clickerObj(this);setZnakKlaw_DWA(\'PLUS\');">END</div></td>\n\
                 </tr>\n\
                 <tr>\n\
                    <td></td>\n\
                    <td><div class="przyciskKl" style="height:43px;font-weight:bold;font-size:18px;" onClick="clickerObj(this);setZnakKlaw_DWA(\'ABC\');" style="min-width:25px;min-height:28px;"><img src="./images/icons32x32/minihand.png" height=38></div></td>\n\
                    <td><div class="przyciskKl" style="height:43px;font-weight:bold;font-size:28px;" onClick="clickerObj(this);setZnakKlaw_DWA(\'0\');" style="min-width:25px;min-height:28px;">0</div></td>\n\
                    <td><div class="przyciskKl" style="height:43px;font-weight:bold;font-size:28px;" onClick="clickerObj(this);setZnakKlaw_DWA(\'.\');" style="min-width:25px;min-height:28px;">.</div></td>\n\
                    <td><div id="KL1" class="przyciskKl" style="height:43px;background:green;" onClick="clickerObj(this);setZnakKlaw_DWA(\'GOTOWE\');" style="min-height:28px;min-width:45px;"><img src="./images/enter.png" height=28></div></td>\n\
                 </tr>\n\
            </table>\n\
            </div>';
            return txt;
    }

    function clickCloseKlaw(){
        $("#klawiatura").slideToggle();
    }

    function hideKlaw(){
        $("#klawiatura").hide();
    }

    window.getParameterByName = function(name) {
       name = name.replace(/[\[]/, "\\\[").replace(/[\]]/, "\\\]");
       var regexS = "[\\?&]" + name + "=([^&#]*)";
       var regex = new RegExp(regexS);
       var results = regex.exec(window.location.href);
       if (results == null) return "";
       else return decodeURIComponent(results[1].replace(/\+/g, " "));
    }