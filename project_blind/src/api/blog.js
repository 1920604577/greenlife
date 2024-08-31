/**
 * 陈志祥
 * @email: 1017850280@qq.com
 */
import http from "@/utils/httpRequest";

export function uploadFile(data) {
    return http({
        url: "/file/imgUpDown",
        method: "post",
        data: data,
        headers:{
            "Content-Type":"multipart/form-data"
        }
    })
}
export function pageNation(data) {
    return http({
        url: "/file/pagingToGetData",
        method: "post",
        data: data
    })
}
export function deletNum(data) {
    return http({
        url: "/file/fileDelete",
        method: "post",
        data: data
    })
}