import Vue from 'vue'
import VueResourse from 'vue-resource'
import App from 'pages/App.vue'

Vue.use(VueResourse);

new Vue({
    el: '#app',
    render: a => a(App)
});
