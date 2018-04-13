/**
 * 
 */
mini.parse();
var isEdit = false;

/************** 左侧表格 ****************/

function onDateChanged(){
	timeSearch();
}

//搜索是否存在记录
function timeSearch(){
	var dateSelect = mini.get("date-select");
	var date = dateSelect.getValue();
	getRecordsList(date);
}

//获取历史记录列表
function getRecordsList(date){
	var data = {};
	if(!isEmpty(date)){
		var begtime = getFirstDayOfWeek(date);
		var endtime = getLastDayOfWeek(date);
		data.begtime = begtime;
		data.endtime = endtime;
	}
	$.ajax({
     type : "GET",
     url  : projectName + "/bed/getRecordList",
     dataType:"json",
     data:data,
     success:function(result){
         if(result.code == 1){
         	if(result.data){
         		var recordGrid = mini.get('time_grid');
             	recordGrid.setData(result.data);
         	}
         } else {
         	mini.alert(result.msg, '错误');
         }
     }
 });
}

//添加记录
function addRecord(){
	var dateSelect = mini.get("date-select");
	if(!dateSelect.getValue()){
		mini.alert('请选择日期', '提示');
		return;
	}
	var date = dateSelect.getValue();
	var begtime = getFirstDayOfWeek(date);
	var endtime = getLastDayOfWeek(date);
	mini.confirm('将建立' + begtime + '~' + endtime + '管理记录', '提示', function(){
		$.ajax({
	        type : "GET",
	        url  : projectName + "/bed/addRecord",
	        dataType:"json",
	        data:{
	        	begtime:begtime,
	        	endtime:endtime,
	        },
	        success:function(result){
	            if(result.code == 1){
	            	var options = {
	            		content: '新建成功',
	            	}
	            	mini.showTips(options);
	            } else {
	            	mini.alert(result.msg, '错误');
	            }
	        }
	    });
	});
}

//左边栏点击事件
function onSelectionChanged(e) {
 var grid = e.sender;
 var record = grid.getSelected();
 if (record) {
 	$('#gridTitle').html('管理日期：' + record.begtime + ' 到 ' + record.endtime);
 	var data = {};
 	data.begtime = record.begtime;
 	data.endtime = record.endtime;
 	$.ajax({
         type : "GET",
         url  : projectName + "/bed/getBedStatus",
         dataType:"json",
         data:data,
         success:function(result){
             if(result.code == 1){
             	loadData(result.data);
             } else {
             	mini.alert(result.msg, '错误');
             }
         }
     });
 }
}

/************** 右侧表格 ****************/

// 状态编辑表头
function createGrid(dateData) {
	var grid = mini.get("statusgrid");
	grid.set({
		columns : [
		           {
		        	   type : "checkcolumn",
		        	   width : 30,
		        	   headerAlign : "center"
		           },
		           {
		        	   field : "bedindex",
		        	   width : 80,
		        	   headerAlign : "center",
		        	   header : "床位编号"
		           },
		           {
		        	   field : "mondiseasename",
		        	   width : 100,
		        	   headerAlign : "center",
		        	   header : dateData[0]
		           },
		           {
		        	   field : "tuediseasename",
		        	   width : 100,
		        	   headerAlign : "center",
		        	   header : dateData[1]
		           },
		           {
		        	   field : "weddiseasename",
		        	   width : 100,
		        	   headerAlign : "center",
		        	   header : dateData[2]
		           },
		           {
		        	   field : "thudiseasename",
		        	   width : 100,
		        	   headerAlign : "center",
		        	   header : dateData[3]
		           },
		           {
		        	   field : "fridiseasename",
		        	   width : 100,
		        	   headerAlign : "center",
		        	   header : dateData[4]
		           },
		           {
		        	   field : "satdiseasename",
		        	   width : 100,
		        	   headerAlign : "center",
		        	   header : dateData[5]
		           },
		           {
		        	   field : "sundiseasename",
		        	   width : 100,
		        	   headerAlign : "center",
		        	   header : dateData[6]
		           }
		           ]
	});
};

// 原状态改变切换提示颜色
function onStatusChanged(e) {
	return;
	var classname = status_background[e.value];
	$(e.el).parent().next().attr("class", classname);
}

// 绑定数据上表事件，上表前修改背景颜色
function bindChangeGridColor(status_background_color){
	var grid = mini.get("statusgrid");
	grid.on("drawcell", function (e) {
	    var record = e.record,
	        column = e.column,
	        field = e.field,
	        value = e.value;
	    // 定义网格背景颜色
	    if (field == "mondiseasename") {
	    	var statusID = record['monbedstatus'];
	    	e.cellStyle = "background:" + status_background_color[statusID];
	    }
	    if (field == "tuediseasename") {
	    	var statusID = record['tuebedstatus'];
	    	e.cellStyle = "background:" + status_background_color[statusID];
	    }
	    if (field == "weddiseasename") {
	    	var statusID = record['wedbedstatus'];
	    	e.cellStyle = "background:" + status_background_color[statusID];
	    }
	    if (field == "thudiseasename") {
	    	var statusID = record['thubedstatus'];
	    	e.cellStyle = "background:" + status_background_color[statusID];
	    }
	    if (field == "fridiseasename") {
	    	var statusID = record['fribedstatus'];
	    	e.cellStyle = "background:" + status_background_color[statusID];
	    }
	    if (field == "satdiseasename") {
	    	var statusID = record['satbedstatus'];
	    	e.cellStyle = "background:" + status_background_color[statusID];
	    }
	    if (field == "sundiseasename") {
	    	var statusID = record['sunbedstatus'];
	    	e.cellStyle = "background:" + status_background_color[statusID];
	    }
	});
}

// 添加床位
function add() {
	if(!isEdit) return;
	//$('#bedIndexInput').val(); // 清空床位编号
	var form = new mini.Form("#addform");
	form.clear();
    
    var grid = mini.get("time_grid");
	var row = grid.getSelected();
	form.setData(row);
	
    var win = mini.get("addWindow");
    win.showAtPos('center', 'middle');
}

// 编辑床位状态
function edit(){
	if(!isEdit) return;
	var grid = mini.get("statusgrid");
	var row = grid.getSelected();
    if (row) {
    	var data = row;
    	weekName.forEach(function(item, i){
    		data[item] = dateData[i];
    	});
    	var form = new mini.Form("#editform");
        form.setData(data);
        
    	var win = mini.get("editWindow");
    	win.setTitle('床位编号:' + data['bedindex']);
        win.showAtPos('center', 'middle');
    } else {
    	mini.alert('请选中一条记录');
    }
}

// 删除床位
function remove() {
	if(!isEdit) return;
    var row = grid.getSelected();
    if (row) {
    	mini.confirm("确定删除选中记录？", "提示", function(action){
    		if(action == 'ok'){
    			var data = {
        				bedindex:row.bedindex,
        				begtime:row.begtime,
        				endtime:row.endtime
        		};
        		$.ajax({
        			type : "GET",
        			url  : projectName + "/bed/deleteRecord",
        			dataType:"json",
        			data:data,
        			success:function(result){
        				if(result.code == 1){
        					var grid = mini.get("time_grid");
        					grid.select(grid.getSelected(), true);
        					var options = {
        						content: '删除床位成功',
        						state:'success',
        						x:'center',
        						y:'center'
        					}
        					mini.showTips(options);
        				} else {
        					mini.alert(result.msg, '错误');
        				}
        			}
        		});
    		}
    	});
    } else {
    	mini.alert('请选中一条记录');
    }
}

// 加载床位状态数据
function loadData(data){
	dateData = data.dateData;
	var bedData = data.bedData;
	var grid = mini.get("statusgrid");
	createGrid(dateData);
	grid.setData(bedData);
	isEdit = true;
}

// 回车事件获取
function onStatusKeyEnter(){
	statusSearch();
}

// 床位编号搜索
function statusSearch() {
    var bedIndexkey = mini.get("bedIndexkey").getValue();
    var grid = mini.get("time_grid");
	var selected = grid.getSelected();
	var data = {
		begtime : selected.begtime,
		endtime : selected.endtime,
		bedIndexkey : bedIndexkey
	};
    $.ajax({
        type : "GET",
        url  : projectName + "/bed/getBedStatus",
        dataType:"json",
        data:data,
        success:function(result){
            if(result.code == 1){
            	loadData(result.data);
            } else {
            	mini.alert(result.msg, '错误');
            }
        }
    });
}

/************** 弹出窗 ****************/

// 编辑状态弹出窗保存按钮
function saveStatus(){
	var form = new mini.Form("#editform");
	var bedStatus = form.getData();
	$.ajax({
        type : "POST",
        url  : projectName + "/bed/saveBedStatus",
        dataType:"json",
        data:{bedStatus:mini.encode(bedStatus)},
        success:function(result){
            if(result.code == 1){
            	var win = mini.get("editWindow");
                win.hide();
                
                var grid = mini.get("time_grid");
                grid.select(grid.getSelected(), true);
            	var options = {
            		content: '保存状态成功',
            		state:'success',
            		x:'center',
            		y:'center'
            	}
            	mini.showTips(options);
            } else {
            	mini.alert(result.msg, '错误');
            }
        }
    });
}

// 编辑状态弹出窗取消按钮
function editCancel(){
	var win = mini.get("editWindow");
    win.hide();
    var form = new mini.Form("#editform");
    form.clear();
}

// 添加床位弹出窗保存按钮
function addBed(){
	var form = new mini.Form("#addform");
	form.validate();
	if (form.isValid() == false) return;
	var bedData = form.getData(); 
	if(isEmpty(bedData.isTemp)){
		mini.alert('请选择是否是临时床位', '错误');
		return;
	}
	$.ajax({
		type : "POST",
		url  : projectName + "/bedmotify/addBed",
		dataType:"json",
		data:{bedData:mini.encode(bedData)},
		success:function(result){
			if(result.code == 1){
				var win = mini.get("addWindow");
				win.hide();

				var grid = mini.get("time_grid");
				grid.select(grid.getSelected(), true);
				var options = {
						content: '添加床位成功',
						state:'success',
						x:'center',
						y:'center'
				}
				mini.showTips(options);
			} else {
				mini.alert(result.msg, '错误');
			}
		}
	});
}

// 添加床位弹出窗取消按钮
function addCancel(){
	var win = mini.get("addWindow");
	win.hide();
	var form = new mini.Form("#addform");
	form.clear();
}

$(function(){ 
	getRecordsList(); // 左表获取
	createGrid(dateData); // 创建表头
	bindChangeGridColor(status_background_color); // 上图绑定
}); 

