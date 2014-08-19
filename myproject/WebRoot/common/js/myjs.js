(function($){
       $.fn.serializeJson=function(){
           var serializeObj={};
           var array=this.serializeArray();
           var str=this.serialize();
           $(array).each(function(){
               if(serializeObj[this.name]){
                   if($.isArray(serializeObj[this.name])){
                       serializeObj[this.name].push(this.value);
                   }else{
                       serializeObj[this.name]=[serializeObj[this.name],this.value];
                   }
               }else{
                   serializeObj[this.name]=this.value;
               }
           });
           return serializeObj;
       };
   })(jQuery);

/**
 * 格式化占位符 Each token must be unique, and must increment in the format {0}, {1}, etc.  Example usage:
 * <pre><code>
	var cls = 'my-class', text = 'Some text';
	var s = String.format('<div class="{0}">{1}</div>', cls, text);
	// s now contains the string: '<div class="my-class">Some text</div>'
	</code></pre>
 * @param {String} string The tokenized string to be formatted
 * @param {String} value1 The value to replace token {0}
 * @param {String} value2 Etc...
 * @return {String} The formatted string
 * @static
 */
String.format = function(format){
var args = Array.prototype.slice.call(arguments, 1);
return format.replace(/\{(\d+)\}/g, function(m, i){
    return args[i];
});
}

//检查字符串是否为空串
String.isEmpty=function(chkStr) {
	if (chkStr == null) {
		return true;
	}
	
	if (typeof(chkStr) == 'undefined') {
		return true;
	}
	
	if (typeof(chkStr) == 'string') {
		chkStr = chkStr.trim();
	}
	
	if (chkStr == "" || chkStr == "null" || chkStr == "&nbsp;") {
		return true;
	}

	return false;
}

// 检查字符串是否不为空串
String.isNotEmpty=function(chkStr) {
	if (chkStr == null) {
		return false;
	}
	
	if (typeof(chkStr) == 'undefined') {
		return false;
	}
	
	if (typeof(chkStr) == 'string') {
		chkStr = chkStr.trim();
	}
	
	if (chkStr == "" || chkStr == "null" || chkStr == "&nbsp;") {
		return false;
	}
	
	return true;
}