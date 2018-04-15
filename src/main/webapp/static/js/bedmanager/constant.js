/**
 * 
 */
var projectName = '/BedManager';
var statusUrl = projectName + '/dict/getStatusDict';
var status_background = {
		'001' : 'status-unused',
		'002' : 'status-surgery',
		'003' : 'status-daytime',
		'004' : 'status-leave',
		'005' : 'status-in'
}

var status_background_color = {
		0 : '#ffffff',
		1 : '#ff0000',
		2 : '#804000',
		3 : '#00ff00',
		4 : '#ffff00'
}

var weekName = [
  'monday',
  'tuesday',
  'wednesday',
  'thursday',
  'friday',
  'saturday',
  'sunday'
];

var dateData = [
  '周一',
  '周二',
  '周三',
  '周四',
  '周五',
  '周六',
  '周日'
];

var bedData = [
  {
	  'bedIndex' : '0000001',
	  'monDiseaseName' : 'Rhino',
	  'monBedStatus' : '002',
	  'tueDiseaseName' : '',
	  'tueBedStatus' : '004',
	  'wedDiseaseName' : '',
	  'wedBedStatus' : '001',
	  'thuDiseaseName' : 'NSD',
	  'thuBedStatus' : '003',
	  'friDiseaseName' : 'Rhino',
	  'friBedStatus' : '005',
	  'satDiseaseName' : '',
	  'satBedStatus' : '005',
	  'sunDiseaseName' : '',
	  'sunBedStatus' : ''
  },
  {
	  'bedIndex' : '0000002',
	  'monDiseaseName' : 'Rhino',
	  'monBedStatus' : '002',
	  'tueDiseaseName' : '',
	  'tueBedStatus' : '004',
	  'wedDiseaseName' : '',
	  'wedBedStatus' : '001',
	  'thuDiseaseName' : 'NSD',
	  'thuBedStatus' : '003',
	  'friDiseaseName' : 'Rhino',
	  'friBedStatus' : '005',
	  'satDiseaseName' : '',
	  'satBedStatus' : '005',
	  'sunDiseaseName' : '',
	  'sunBedStatus' : ''
  }
];