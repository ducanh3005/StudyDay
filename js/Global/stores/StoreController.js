/*
    React Native 使用react-native-simple-store 对数据进行缓存。
    这里针对Store 进行自己使用情况封装。
 */
import stores from 'react-native-simple-store';

let storeType ={
    save: function save(key,value) {
        stores.save(key,value);
    },

    get: async function get(key) {
        let value = await stores.get(key);
        return value;
    },

    delete: async function _delete(key) {
        await stores.delete(key);
    }
}
export default storeType;