function getDateStr(b,c,a){var d=""+b;c++;if(c<10){d=d+"-0"+c}else{d=d+"-"+c}if(a<10){d=d+"-0"+a}else{d=d+"-"+a}return d}function daysInMonth(a,b){switch(b){case 1:if(0==a%4){if((0==a%100)&&(0!=a%8)){return 28}return 29}else{return 28}break;case 3:case 5:case 8:case 10:return 30;default:return 31}}function addMonth(a,b){year=getYear(a);month=a.getMonth();month+=b;while(month>11){year++;month-=12}while(month<0){year--;month+=12}a.setFullYear(year,month)}function quarterStartMonth(a){month=a.getMonth();if(month<3){return 0}if(month<6){return 3}if(month<9){return 6}return 9}function quarterEndMonth(a){month=a.getMonth();if(month<3){return 2}if(month<6){return 5}if(month<9){return 8}return 11}function getYear(a){var b=a.getYear();return b<1900?1900+b:b}function dateSelect(e,g,d){var c;var f;var a;var b=new Date();if(e=="0"){g.value="";d.value=""}else{if(e=="d0"){c=getYear(b);f=b.getMonth();a=b.getDate();g.value=getDateStr(c,f,a);d.value=getDateStr(c,f,a)}else{if(e=="m0"){c=getYear(b);f=b.getMonth();g.value=getDateStr(c,f,1);d.value=getDateStr(c,f,daysInMonth(c,f))}else{if(e=="m1"){addMonth(b,-1);c=getYear(b);f=b.getMonth();g.value=getDateStr(c,f,1);d.value=getDateStr(c,f,daysInMonth(c,f))}else{if(e=="m2"){addMonth(b,-2);c=getYear(b);f=b.getMonth();g.value=getDateStr(c,f,1);d.value=getDateStr(c,f,daysInMonth(c,f))}else{if(e=="m3"){addMonth(b,-3);c=getYear(b);f=b.getMonth();g.value=getDateStr(c,f,1);d.value=getDateStr(c,f,daysInMonth(c,f))}else{if(e=="m4"){addMonth(b,-4);c=getYear(b);f=b.getMonth();g.value=getDateStr(c,f,1);d.value=getDateStr(c,f,daysInMonth(c,f))}else{if(e=="m5"){addMonth(b,-5);c=getYear(b);f=b.getMonth();g.value=getDateStr(c,f,1);d.value=getDateStr(c,f,daysInMonth(c,f))}else{if(e=="y0"){c=getYear(b);f=b.getMonth();g.value=getDateStr(c,0,1);d.value=getDateStr(c,f,daysInMonth(c,f))}else{if(e=="y1"){c=getYear(b);g.value=getDateStr(c-1,0,1);d.value=getDateStr(c-1,11,31)}else{if(e=="q0"){c=getYear(b);g.value=getDateStr(c,quarterStartMonth(b),1);d.value=getDateStr(c,quarterEndMonth(b),daysInMonth(c,quarterEndMonth(b)))}else{if(e=="q1"){addMonth(b,-3);c=getYear(b);g.value=getDateStr(c,quarterStartMonth(b),1);d.value=getDateStr(c,quarterEndMonth(b),daysInMonth(c,quarterEndMonth(b)))}}}}}}}}}}}}};