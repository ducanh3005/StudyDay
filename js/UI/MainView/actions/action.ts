/**
 * 首页展示。action具体方法 入口。
 */
import * as ActionType from '../actions/actionType';
/**
 * 第一个接口，直接打开界面获取当前日期的点位集合
 * @param {*} dateTime 当前传递过来的时间
 * @param {*} id 当前传递id
 */
export function getToDayPoints(id: string, dateTime: Date) {
    return (dispatch: Function) => getPoints(dispatch, id, dateTime);
}

export function getUserKey() {
    return '1136871008682414';
}


async function getPoints(dispatch: any, id: string, dateTime: Date) {
    let userKey = getUserKey();
    let json = '{"1136871008682414":[{"id":1175098359890257,"userid":1136871008682414,"name":"张宇辉","longitude":108.882348,"latitude":34.229525,"location":"陕西省西安市雁塔区团结南路73号靠近西安高新医院","time":1586487189592},{"id":1175148340068742,"userid":1136871008682414,"name":"张宇辉","longitude":108.882286,"latitude":34.229639,"location":"陕西省西安市雁塔区团结南路73号靠近西安高新医院","time":1586490220438},{"id":1175178804117890,"userid":1136871008682414,"name":"张宇辉","longitude":108.882082,"latitude":34.230012,"location":"陕西省西安市雁塔区团结南路73号靠近西安高新医院","time":1586492050805},{"id":1175199758319984,"userid":1136871008682414,"name":"张宇辉","longitude":108.882369,"latitude":34.229797,"location":"陕西省西安市雁塔区团结南路73号靠近西安高新医院","time":1586493881295},{"id":1175239176749442,"userid":1136871008682414,"name":"张宇辉","longitude":108.882287,"latitude":34.229653,"location":"陕西省西安市雁塔区团结南路73号靠近西安高新医院","time":1586495711871},{"id":1175297223000461,"userid":1136871008682414,"name":"张宇辉","longitude":108.882352,"latitude":34.229785,"location":"陕西省西安市雁塔区团结南路73号靠近西安高新医院","time":1586499294543},{"id":1175335782384007,"userid":1136871008682414,"name":"张宇辉","longitude":108.882286,"latitude":34.229643,"location":"陕西省西安市雁塔区团结南路73号靠近西安高新医院","time":1586501656172}]}';
    let obj  = JSON.parse(json);
    dispatch(updateView(id, dateTime, obj[userKey]));
}

export function updateView(id: string, dateTime: Date, key: any[]) {
    let todayPoints: { title: string; address: string; longitude: string; latitude: string; }[] = [];
    if (key) {
        for (let step of key) {
            todayPoints.push({
                title: step.location,
                address: step.location,
                longitude: step.longitude + '',
                latitude: step.latitude + '',
            });
        }
    }
    return {
        type: ActionType.DATE_CHANGE,
        id: id,
        selectDate: dateTime,
        todayPoints,
    }
}