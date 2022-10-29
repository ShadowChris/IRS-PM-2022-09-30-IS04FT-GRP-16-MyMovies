import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from "@/views/Login";
import Register from "@/views/Register";

import HomeInform from "@/views/HomeSample";

import AdminDetails from "@/views/Management/AdminDetails";

import MovieInfo from "@/views/Management/MovieInfo";
import MovieAdd from "@/views/Management/MovieAdd";
import MovieDetailsBackend from "@/views/Management/MovieDetailsBackend";

import Home from "@/views/Home"
import MovieDetails from "@/views/MovieDetails";

import MovieView from "@/views/MovieView"

import Table from "@/views/Table";

Vue.use(VueRouter)

const routes = [

    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/HomeInform',
        name: 'HomeInform',
        component: HomeInform
    },
    {
        path: '/login',
        name: 'Login',
        component: Login,
        //单个路由守卫，如果已经获取了session信息，访问登录界面就直接进入主界面
        beforeEnter: (to, from, next) => {
            if(sessionStorage.getItem("user") != null) {
                next("HomeInform")
            } else {
                next()
            }
        }
    },
    {
        path: '/Register',
        name: 'Register',
        component: Register,
        beforeEnter: (to, from, next) => {
            if(sessionStorage.getItem("user") != null) {
                next("HomeInform")
            } else {
                next()
            }
        }
    },
    {
        path: '/AdminDetails',
        name: 'AdminDetails',
        component: AdminDetails
    },

    {
        path: '/MovieInfo',
        name: 'MovieInfo',
        component: MovieInfo
    },
    {
        path: '/MovieDetailsBackend/:id',
        name: 'MovieDetailsBackend',
        component: MovieDetailsBackend
    },
    {
        path: '/MovieAdd',
        name: 'MovieAdd',
        component: MovieAdd
    },
    {
        path: '/Home',
        name: 'Home',
        component: Home
    },


    {
        path: '/MovieDetails/:id',
        name: 'MovieDetails',
        component: MovieDetails
    },

    {
        path: '/Table',
        name: 'Table',
        component: Table
    },

    {
        path: '/MovieView',
        name: 'MovieView',
        component: MovieView
    }

]


const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

//路由全局守卫
// router.beforeEach((to, from, next) => {
//     if( (to.name !== 'Register' && to.name !== 'Login') && sessionStorage.getItem("user") == null) {
//
//         // alert(to.name)
//         next("Login")
//     } else {
//         next()
//     }
//
// });

export default router
