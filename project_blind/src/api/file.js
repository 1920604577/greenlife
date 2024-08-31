
/**
 * 杨易达
 * @email: y51288033@outlook.com
 */
import http from "@/utils/httpRequest";

/**
 * 分页获取下载列表
 * @param {*} data 
 * @returns 
 */
export function pagingtoGetData(data) {
    return http({
        url: "/file/pagingToGetData",
        method: "post",
        data: data
    })
}

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

export function deleteHandeler(id){
    return http({
        url: "file/fileDelete",
        method: "post", //请求
        params:id, //参数的携带方式 id:携带方式后面要的东西
   
})

}

export function updateFile(fileUpdateBo){
    return http({
        url: "file/updateFile",
        method: "post", //请求
        data:fileUpdateBo, //参数的携带方式 id:携带方式后面要的东西
   
})

}

/**
 * deleteList
 * @param {*} list 
 * @returns 
 */
export function deleteFlieList(list){
    return http({
        url: "file/deleteList",
        method: "post", //请求
        data:list, //参数的携带方式 id:携带方式后面要的东西
   
})
}