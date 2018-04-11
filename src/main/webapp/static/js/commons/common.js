/**
 * 
 */
// 判断是否为空
function isEmpty(obj) {
	if (obj === null) return true;
	if (typeof obj === 'undefined') {
		return true;
	}
	if (typeof obj === 'string') {
		if (obj === "") {
			return true;
		}
		var reg = new RegExp("^([ ]+)|([　]+)$");
		return reg.test(obj);
	}
	return false;
}