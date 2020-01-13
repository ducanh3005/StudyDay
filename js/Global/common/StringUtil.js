import values from './values'

class Resouce {

    valueString(key,defaultValue =''){
        let result = this.getString(key);
        //没有远程资源，拿相应的资源
        if(result){
            return result;
        }

        //本地没有，拿默认值
        if(defaultValue){
            return defaultValue;
        }
        if(!key){
            return defaultValue;
        }

        //都没有，再去中文里取一下娄底
        if (key.indexOf('${mobileLayout') === 0) {
            return values[key.slice(2, key.length - 1)];
        }
        return values[key]?values[key]:"";
    }

    getString(key){
        let resource = values;
        // console.log("Language_Key:"+ global.LangueKey);
        if(!key){
            return null;
        }

        if (key.indexOf('${mobileLayout') === 0) {
            return resource[key.slice(2, key.length - 1)];
        }
        return resource[key];
    }

}

const resource = new Resouce();

export default function valueString(key,defaultValue='') {
    return resource.valueString(key,defaultValue);
}