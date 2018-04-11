/**
 * 时间日期工具类
 */
//获取这周的周一  
Date.prototype.format = function(fmt) { 
     var o = { 
        "M+" : this.getMonth()+1,                 //月份 
        "d+" : this.getDate(),                    //日 
        "h+" : this.getHours(),                   //小时 
        "m+" : this.getMinutes(),                 //分 
        "s+" : this.getSeconds(),                 //秒 
        "q+" : Math.floor((this.getMonth()+3)/3), //季度 
        "S"  : this.getMilliseconds()             //毫秒 
    }; 
    if(/(y+)/.test(fmt)) {
            fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
    }
     for(var k in o) {
        if(new RegExp("("+ k +")").test(fmt)){
             fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
         }
     }
    return fmt; 
}

function getFirstDayOfWeek(date) {  
    var weekday = date.getDay()||7; //获取星期几,getDay()返回值是 0（周日） 到 6（周六） 之间的一个整数。0||7为7，即weekday的值为1-7  
  
    date.setDate(date.getDate()-weekday+1);//往前算（weekday-1）天，年份、月份会自动变化  
    return timeFormat(date);  
}
//获取这周的周日  
function getLastDayOfWeek(date) {  
    var weekday = date.getDay()||7; //获取星期几,getDay()返回值是 0（周日） 到 6（周六） 之间的一个整数。0||7为7，即weekday的值为1-7  
  
    date.setDate(date.getDate()+7-weekday);//往后算（weekday-1）天，年份、月份会自动变化  
    return timeFormat(date);
}

//日期格式化，返回值形式为yy-mm-dd  
function timeFormat(date) {
  if (!date || typeof(date) === "string") {
      this.error("参数异常，请检查...");  
  }

  return date.format("yyyy-MM-dd");
}