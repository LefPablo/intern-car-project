// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
// import Vue from "vue";
// import Vuetable from "vuetable-2";

Vue.use(Vuetable);
// Vue.config.productionTip = false;
//
// /* eslint-disable no-new */
// Vue.component('test', {
//     template: '<p>Hello world</p>'
// })
//
// Vue.component('vuet' , {
//     components: {
//         Vuetable
//     },
//     data: function() {
//         return {
//             fields: [
//                 {
//                     name: "name",
//                     title: '<i class="grey user outline icon"></i>Name'
//                 },
//                 {
//                     name: "email",
//                     title: '<i class="grey mail outline icon"></i>Email'
//                 },
//                 {
//                     name: "phone",
//                     title: '<i class="grey sitemap icon"></i>Group'
//                 },
//                 {
//                     name: "id",
//                     title: '<i class="grey birthday icon"></i>Birthdate'
//                 },
//             ]
//         };
//     },
//     template:
//         '<vuetable ' +
//         'api-url="http://localhost:8080/reservations/" ' +
//         ':fields="fields" ' +
//         'data-path="" ' +
//         'pagination-path ' +
//         '></vuetable>'
// })
//
// new Vue({
//     el: "#app",
//     template:
//         '<div id="app" class="ui container">' +
//         '<h1>&lt;Vuetable-2&gt;</h1>' +
//         '<vuet></vuet>' +
//         '</div>'
// });

// Vue.component('vuet', {
//
//     template:
//         '<vuetable ' +
//         'api-url="https://vuetable.ratiw.net/api/users" ' +
//         ':fields="fields" ' +
//         'data-path="data" ' +
//         'pagination-path ' +
//         '></vuetable>'
// })

var app = new Vue({
    el: "#app",
    data: {
        fields: [
                {
                    name: "name",
                    title: '<i class="grey user outline icon"></i>Name'
                },
                {
                    name: "email",
                    title: '<i class="grey mail outline icon"></i>Email'
                },
                {
                    name: "phone",
                    title: '<i class="grey sitemap icon"></i>Group'
                },
                {
                    name: "id",
                    title: '<i class="grey birthday icon"></i>Birthdate'
                },
            ]
    },
});
