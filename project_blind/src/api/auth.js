/**
 * 陈志祥
 * @email: 1017850280@qq.com
 */
import http from "@/utils/httpRequest";

export function login(data) {
    return http({
        url: "/user/login",
        method: "post",
        data: data
    })
}

