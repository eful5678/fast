var APP_LOG_LIFECYCLE_EVENTS = true;

var app = new Vue({
    el: '#app',
    data: {
        message: 'Hello Vue!',
        sitename: 'Vue Start',
        product: {
            id: 1001,
            title: 'Todays whether',
            description: 'very hot today',
            price: 20000,
        }
    },
    filters: {
        formatPrice: function(price){
            if(!parseInt(price)){
                return "";
            }
            if(price > 99999){
                var priceString = (price / 100).toFixed(2);
                var priceArray = priceString.split("").reverse();
                var index = 3;
                while(priceArray.length > index + 3){
                    priceArray.splice(index + 3, 0, ",");
                    index += 4;
                }
                return "$" + priceArray.reverse().join("");
            }else{
                return "$" + (price / 100).toFixed(2);
            }
        }
    },
    beforeCreate: function () {
        if (APP_LOG_LIFECYCLE_EVENTS) {
            console.log("beforeCreate");
            console.log(this);
        }
    },
    created: function () {
        if (APP_LOG_LIFECYCLE_EVENTS) {
            console.log("created");
        }
    },
    beforeMount: function () {
        if (APP_LOG_LIFECYCLE_EVENTS) {
            console.log("beforeMount");
        }
    },
    mounted: function () {
        if (APP_LOG_LIFECYCLE_EVENTS) {
            console.log("mounted");
        }
    },
    beforeUpdate: function () {
        if (APP_LOG_LIFECYCLE_EVENTS) {
            console.log("beforeUpdate");
        }
    },
    updated: function() {
        if(APP_LOG_LIFECYCLE_EVENTS){
            console.log("updated");
        }
    },
    beforeDestroy: function() {
        if(APP_LOG_LIFECYCLE_EVENTS){
            console.log("beforeDestroy");
        }
    },
    destroyed: function() {
        if(APP_LOG_LIFECYCLE_EVENTS){
            console.log("destroyed");
        }
    }
});
