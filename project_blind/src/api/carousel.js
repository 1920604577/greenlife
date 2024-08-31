// /$$
//  $ @Author: tianleiyu 
//  $ @Date: 2024-03-13 22:26:30
//  $ @LastEditTime: 2024-03-13 22:27:36
//  $ @LastEditors: tianleiyu
//  $ @Description: 
//  $ @FilePath: /vue-example-main/src/api/carousel.js
//  $ @可以输入预定的版权声明、个性签名、空行等
//  $/
import http from "@/utils/httpRequest";

/**
 * 分页获取列表
 * @param {*} data 
 * @returns 
 */
export function getDataByPage(data) {
    return http({
        url: "/carousel/queryByPage",
        method: "post",
        data: data
    })
}

/**
 * 新增
 * @param {*} carousel {}
 * @returns 
 */
export function addCarousel(carousel) {
    return http({
        url: `/carousel/add`,
        method: "post",
        data:carousel
    })
}

/**
 * 根据ID获取
 * @param {number} id 
 * @returns 
 */
export function selectById(id) {
    return http({
        url: `/carousel/queryById/${id}`,
        method: "get"
    })
}


/**
 * 更新carousel
 * @param {*} carousel {}
 * @returns 
 */
export function updateCarousel(carousel) {
    return http({
        url: `/carousel/edit`,
        method: "post",
        data: carousel
    })
}

/**
 * deleteById
 * @param {*} id 
 * @returns 
 */
export function deleteById(id) {
    return http({
        url: `/carousel/deleteById/${id}`,
        method: "post"
    })
}
