// axios-config.js
import axios from 'axios';

// Create an instance of Axios
const axiosInstance = axios.create();

// Add an interceptor to set the Accept-Language header before each request
axiosInstance.interceptors.request.use(config => {
    // Retrieve the lang parameter from localStorage or any other source
    const lang = localStorage.getItem('lang') || 'en';

    // Set the Accept-Language header
    config.headers['Accept-Language'] = lang;

    return config;
}, error => {
    // Handle request error
    return Promise.reject(error);
});

export default axiosInstance;