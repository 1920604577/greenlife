/**
 * 杨易达
 * @email: y51288033@outlook.com
 */
import http from "@/utils/httpRequest";

/**
 * 下载文件
 * todo 没时间改真实数据
 * @param {*} data 
 */
export function downloadFile(data){
    return http({
        responseType: 'blob' ,
        url: "/file/getFile",
        method: "get",
        params: data
    })
}


/**
 * 文件上传
 * @param {*} data 
 */
export function fileUpload(data){
    // Create a FormData object
    const formData = new FormData();
    
    // Append the file to the FormData object with the key 'file'
    formData.append('file', data.file);
    formData.append("channelId",data.channelId);

    return http({
        url: "/file/imgUpDown",
        method: "post",
        data: formData,
        headers:{
            "Content-Type":"multipart/form-data"
        }
    })
}

//findByCarouselId
export function findByCarouselId(data){
    return http({
        url: "/carouselFile/findByCarouselId",
        method: "get",
        params: data
    })
}

/**
 * 轮播图
 * @param {*} data 
 * @returns 
 */
// 分页
export function carouselPaganation(data) {
    return http({
        url: "/carouselFile/queryByPage",
        method: "post",
        data: data
    })
}

// 新增接口
export function carouselAdd(data) {
    return http({
        url: "/carouselFile/add",
        method: "post",
        data: data
    })
}
//删除接口
export function carouselDelet(data) {
    return http({
        url: `/carouselFile/deleteById/${data.id}`,
        method: "post",
        data: data
    })
}
//编辑接口
export function carouselEdit(data) {
    return http({
        url: "/carouselFile/edit",
        method: "post",
        data: data
    })
}