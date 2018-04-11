/**
 * 
 */
mini.parse();
var isEdit = false;
var grid = mini.get("datagrid1");
function createGrid(dateData) {
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
		        	   allowSort : true,
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
createGrid(dateData);

//function setData(bedData){
//	grid.setData(bedData);
//}

// setData(bedData);

function onStatusChanged(e) {
	return;
	var classname = status_background[e.value];
	$(e.el).parent().next().attr("class", classname);
}

/*function onBeforeOpen(e) {
    var grid = mini.get("datagrid1");
    var menu = e.sender;
            
    var row = grid.getSelected();
    var rowIndex = grid.indexOf(row);            
    if (!row) {
        e.cancel = true;
        //阻止浏览器默认右键菜单
        e.htmlEvent.preventDefault();
        return;
    }
    ////////////////////////////////
    var editItem = mini.getbyName("edit", menu);
    var removeItem = mini.getbyName("remove", menu);
    editItem.show();
    removeItem.enable();
}
function onAdd(e) {
    alert("新增记录");
}
function onEdit(e) {
	console.log(grid);
    var row = grid.getSelected();
    if (row) {
        var win = mini.get("editForm");
        win.showAtPos(200, 300);
    }
}
function onRemove(e) {
    var row = grid.getSelected();
    if (row) {
        alert("删除：" + row.loginname)
    }   
}*/

// 绑定数据上表事件
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

function add() {
	if(!isEdit) return;
	var data = {};
	weekName.forEach(function(item, i){
		data[item] = dateData[i];
	});
	var form = new mini.Form("#editform");
    form.clear();
    form.setData(data, false);
    
	var win = mini.get("editWindow");
	win.setTitle('新增床位');
    win.showAtPos('center', 'middle');
}

function edit(){
	if(!isEdit) return;
	var grid1 = mini.get("datagrid1");
	var row = grid1.getSelected();
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
    }
}

function remove() {
	if(!isEdit) return;
    var rows = grid.getSelecteds();
    if (rows.length > 0) {
        if (confirm("确定删除选中记录？")) {
            var ids = [];
            for (var i = 0, l = rows.length; i < l; i++) {
                var r = rows[i];
                ids.push(r.id);
            }
            var id = ids.join(',');
            grid.loading("操作中，请稍后......");
            setData(bedData);
            /*$.ajax({
                url: "../data/AjaxService.aspx?method=RemoveEmployees&id=" +id,
                success: function (text) {
                    grid.reload();
                },
                error: function () {
                }
            });*/
        }
    } else {
        alert("请选中一条记录");
    }
}

// 搜索是否存在记录
function timeSearch(){
	var dateSelect = mini.get("date-select");
	var date = dateSelect.getValue();
	getRecordsList(date);
}

// 获取历史记录列表
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

getRecordsList();

// 添加记录
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

// 左边栏点击事件
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

// 加载床位状态数据
function loadData(data){
	dateData = data.dateData;
	var bedData = data.bedData;
	var grid = mini.get("datagrid1");
	createGrid(dateData);
	grid.setData(bedData);
	isEdit = true;
}

// 保存状态信息
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
            	var options = {
            		content: '保存状态成功',
            	}
            	mini.showTips(options);
            } else {
            	mini.alert(result.msg, '错误');
            }
        }
    });
}

// 取消
function cancel(){
	var win = mini.get("editWindow");
    win.hide();
    var form = new mini.Form("#editform");
    form.clear();
}

$(function(){ 
	
}); 
