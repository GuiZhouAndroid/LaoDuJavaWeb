function jQuery(selector){
    if (typeof selector == "string") {
        if (selector.charAt(0) == "#") {
            domObj = document.getElementById(selector.substring(1))
            return new jQuery()
        }
    }
    if (typeof selector == "function") {
        window.onload = selector
    }
    this.html = function(htmlStr){
        domObj.innerHTML = htmlStr
    }
    this.click = function(fun){
        domObj.onclick = fun
    }
    this.focus = function (fun){
        domObj.onfocus = fun
    }
    this.blur = function(fun) {
        domObj.onblur = fun
    }
    this.change = function (fun){
        domObj.onchange = fun
    }
    this.val = function(v){
        if (v == undefined) {
            return domObj.value
        }else{
            domObj.value = v
        }
    }

    // 静态的方法，发送ajax请求
    /**
     * 分析：使用ajax函数发送ajax请求的时候，需要程序员给我们传过来什么？
     *      请求的方式(type)：GET/POST
     *      请求的URL(url)：url
     *      请求时提交的数据(data)：data
     *      请求时发送异步请求还是同步请求(async)：true表示异步，false表示同步。
     */
    jQuery.ajax = function(jsonArgs){
        // 1.
        var xhr = new XMLHttpRequest();
        // 2.
        xhr.onreadystatechange = function(){
            if (this.readyState == 4) {
                if (this.status == 200) {
                    // 我们这个工具类在封装的时候，先不考虑那么多，假设服务器返回的都是json格式的字符串。
                    var jsonObj = JSON.parse(this.responseText)
                    // 调用函数
                    jsonArgs.success(jsonObj)
                }
            }
        }

        if (jsonArgs.type.toUpperCase() == "POST") {
            // 3.
            xhr.open("POST", jsonArgs.url, jsonArgs.async)
            // 4.
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
            xhr.send(jsonArgs.data)
        }

        if (jsonArgs.type.toUpperCase() == "GET") {
            xhr.open("GET", jsonArgs.url + "?" + jsonArgs.data, jsonArgs.async)
            xhr.send()
        }

    }
}
$ = jQuery

// 这里有个细节，执行这个目的是为了让静态方法ajax生效。
new jQuery()

