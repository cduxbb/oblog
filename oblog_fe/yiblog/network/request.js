import axios from 'axios';
import {
    baseUrl
} from './config'
axios.defaults.headers.common['Content-Type'] = 'application/json;charset=UTF-8'

export function request(config) {

    var source = axios.CancelToken.source();
    // 1.创建实例
    const instance = axios.create({
        baseURL: baseUrl,
        timeout: 5000,
    })
    return instance(config)
}