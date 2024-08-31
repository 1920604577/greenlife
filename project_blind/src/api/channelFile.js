
/**
 * 杨易达
 * @email: y51288033@outlook.com
 */
import http from "@/utils/httpRequest";

/**
 * 将文件插入通道
 * @param {*} data 
 * @returns 
 */
export function insertFileToChannel(data){
    return http({
        url: "/channelFiles/add",
        method: "post",
        params: data
    })
}

/**
 * 分页查询
 * @param {*} data 
 * @returns 
 */
export function getDataByPage(channelFiles){
    return http({
        url: "channelFiles/queryByPage",
        method: "post",
        params: channelFiles
    })
}

/**
 * 根据ID查询
 * @param {*} id 
 * @returns 
 */
export function selectById(id){
    return http({
        url: `channelFiles/queryById/${id}`,
        method: "get"
    })
}

/**
 * 修改
 * @param {*} data 
 * @returns 
 */
export function updateChannelsFile(data){
    return http({
        url: "channelFiles/edit",
        method: "post",
        params: data
    })
}

/**
 * 删除
 * @param {*} id 
 * @returns 
 */
export function deleteById(id){
    return http({
        url: `channelFiles/deleteById/${id}`,
        method: "post"
    })
}

/**
 * 根据通道ID查询
 * @param {*} channelID 
 * @returns 
 */
export function getFileInformation(channelID){
    return http({
        url: `channelFiles/getFileInformation/${channelID}`,
        method: "get"
    })
}