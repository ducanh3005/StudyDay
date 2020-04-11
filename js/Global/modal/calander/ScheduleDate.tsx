/**
 * 自定义日历，提供日期选择功能，自定义一个简易日历。
 */
import React from 'react';

import {
    View,
    StyleSheet,
    Text,
    Modal,
    TouchableOpacity,
    Dimensions,
    Image,
    FlatList,
} from 'react-native';
const { width, height } = Dimensions.get('window')
import moment from 'moment';
const today = new Date();
let toYear: number = Number.parseInt(moment(new Date()).format('YYYY'))
let toMonth: number = Number.parseInt(moment(new Date()).format('MM'))

export interface IProps {
    dateChanged: any,
}
export interface IState {
    modalVisible: boolean,
    selectedDate: any,
    dayData: any[],
    month: any,
    year: any,
    color: any[],
}

export default class ScheduleDetail extends React.Component<IProps, IState> {

    constructor(props: IProps) {
        super(props)
        this.state = {
            modalVisible: false,
            selectedDate: '',
            dayData: [],
            month: toMonth,
            year: toYear,
            color: [],
        }
    }

    showModal(year: any, month: any, day: any) {
        if (year && year !== 0) {
            toYear = year;
            toMonth = month;
            this.setState({
                month: toMonth,
                year: toYear,
                selectedDate: (toYear + '-' + toMonth + '-' + day),
            })
            //刷新日历
            this.initCalander();
        }
        this.setState({ modalVisible: true })
    }

    cancelModal() {
        this.setState({ modalVisible: false })
    }

    dateChanged(date: string) {
        this.setState({ modalVisible: false });
        this.props.dateChanged(date);
    }

    // ==============================日历相关======================================

    componentDidMount() {
        this.initCalander();
    }

    initCalander = () => {
        let dayCount = this.getDaysOfMonth(toYear, toMonth)
        let dayIn = this.getFirstDay(toYear, toMonth)
        let temp = []
        let color = []
        for (let i = 0; i < dayIn; i++) {
            temp.push(' ')
            color.push(0)
        }
        for (let i = 1; i <= dayCount; i++) {
            temp.push(i)
            color.push(0)
        }
        this.setState({
            dayData: temp,
            color: color,
        })

    }


    createHeaderBar = () => {
        return (
            <View style={styles.headerBar}>

                <TouchableOpacity
                    activeOpacity={1}
                    style={styles.outArrow}
                    onPress={this.clickPrevious}>
                    <Text style={{ fontSize: 14, color: "#4E80F5" }} >上个月</Text>
                </TouchableOpacity>
                <Text style={styles.text}>
                    {this.state.year + '/' + this.state.month}
                </Text>
                <TouchableOpacity
                    activeOpacity={1}
                    style={styles.outArrow}
                    onPress={this.clickNext}>
                    <Text style={{
                        fontSize: 14,
                        color: '#4E80F5',
                    }}>下个月</Text>
                </TouchableOpacity>

            </View>
        )
    }

    createDayBar = () => {
        return (
            <View style={styles.weekBar}>
                {this.createLab()}
            </View>
        )
    }

    createLab = () => {
        let dateArray = ['日', '一', '二', '三', '四', '五', '六']
        let array = []
        for (let i = 1; i < 8; i++) {
            array.push(
                <View
                    key={i}
                    style={styles.week}>
                    <Text style={styles.text}>
                        {dateArray[i - 1]}
                    </Text>
                </View>
            )
        }
        return array
    }
    creatContent = () => {
        return (
            <FlatList
                data={this.state.dayData}
                numColumns={7}
                horizontal={false}
                extraData={this.state}
                renderItem={this.renderItem}
                keyExtractor={this.keyExtractor} />
        )
    }
    clickItem = (item: any, index: any, couldSelect: boolean) => {
        if (!couldSelect) {
            return;
        }
        if (item == ' ') {
            return
        }
        let temp = this.state.color
        if (temp[index] == 1) {
            temp[index] = 0
        }
        else if (temp[index] == 0) {
            temp[index] = 1
        }

        this.setState({
            selectedDate: (toYear + '-' + toMonth + '-' + item),
            color: temp
        }, () => {
            this.dateChanged(this.state.selectedDate)
        })

    }

    renderItem = ({ item, index }: { item: any, index: any }) => {
        //选择的时间
        let time = new Date((toYear + '-' + toMonth + '-' + item).replace(/-/g, '/'));
        let couldSelect = today >= time;
        if (couldSelect) {
            return (
                <TouchableOpacity
                    activeOpacity={1}
                    onPress={this.clickItem.bind(this, item, index, couldSelect)}>
                    <View
                        style={{
                            width: width / 7,
                            height: 40,
                            justifyContent: 'center',
                            alignItems: 'center',
                            borderRadius: 5,  //圆角5
                            borderWidth: 1,
                            borderColor: 'white',
                            backgroundColor: (toYear + '-' + toMonth + '-' + item) === this.state.selectedDate ? '#3576F0' : 'white',

                        }}>
                        <Text
                            style={{ color: (toYear + '-' + toMonth + '-' + item) === this.state.selectedDate ? 'white' : '#243047' }}>{item}</Text>
                    </View>
                </TouchableOpacity>
            )
        } else {
            return (
                <TouchableOpacity
                    activeOpacity={1}
                    onPress={this.clickItem.bind(this, item, index, couldSelect)}>
                    <View
                        style={{
                            width: width / 7,
                            height: 40,
                            justifyContent: 'center',
                            alignItems: 'center',
                            borderRadius: 5,  //圆角5
                            borderWidth: 1,
                            borderColor: 'white',
                            backgroundColor: 'white',

                        }}>
                        <Text style={{ color: '#6A7280' }}>{item}</Text>
                    </View>
                </TouchableOpacity>
            )
        }

    }

    keyExtractor = (item: any, index: any) => 'Zdate' + index

    getDaysOfMonth = (year: any, month: any) => {
        let day = new Date(year, month, 0)
        let dayCount = day.getDate()
        return dayCount
    }

    getFirstDay = (year: any, month: any) => {
        let day = new Date(year, month - 1)
        let dayCount = day.getDay()
        return dayCount
    }
    clickNext = () => {
        toMonth++
        if (toMonth > 12) {
            toMonth = 1
            toYear++
        }
        this.setState({
            month: toMonth,
            year: toYear
        })

        let dayCount = this.getDaysOfMonth(toYear, toMonth)
        let dayIn = this.getFirstDay(toYear, toMonth)
        let temp = []
        let color = []
        for (let i = 0; i < dayIn; i++) {
            temp.push(' ')
            color.push(0)
        }
        for (let i = 1; i <= dayCount; i++) {
            temp.push(i)
            color.push(0)
        }
        this.setState({
            dayData: temp,
            color: color,
        })
    }

    clickPrevious = () => {
        toMonth--
        if (toMonth < 1) {
            toMonth = 12
            toYear--
        }
        this.setState({
            month: toMonth,
            year: toYear
        })
        let dayCount = this.getDaysOfMonth(toYear, toMonth)
        let dayIn = this.getFirstDay(toYear, toMonth)
        let temp = []
        for (let i = 0; i < dayIn; i++) {
            temp.push(' ')
        }
        for (let i = 1; i <= dayCount; i++) {
            temp.push(i)
        }
        this.setState({
            dayData: temp
        })
    }
    render() {
        return <Modal animationType="fade"  //slide
            visible={this.state.modalVisible}
            transparent={true}
            onRequestClose={() => this.setState({ modalVisible: false })}
        >
            <View style={styles.modalStyle}>
                <View style={styles.subView}>
                    <View style={styles.canlendarStyle}>
                        {this.createHeaderBar()}
                        <View style={styles.line} />
                        {this.createDayBar()}
                        {this.creatContent()}
                        <View style={styles.line} />
                    </View>
                    {/*取消按钮*/}
                    <TouchableOpacity
                        style={styles.cancel}
                        onPress={() => this.setState({ modalVisible: false })}>
                        <Text style={styles.actionItemTitle}>取消</Text>
                    </TouchableOpacity>
                </View>
            </View>
        </Modal>
    }
}

const styles = StyleSheet.create({
    headerBar: {
        height: 50,
        width: width,
        backgroundColor: '#FFFFFF',
        flexDirection: 'row',
        justifyContent: 'space-between',
        alignItems: 'center'
    },
    line: {
        width: '100%',
        height: 0.5,
        alignSelf: 'center',
        borderBottomWidth: 1,
        borderBottomColor: '#dddddd',
    },
    weekBar: {
        height: 40,
        width: width,
        alignItems: 'center',
        flexDirection: 'row',
    },
    week: {
        width: width / 7,
        height: 40,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#FFFFFF'
    },
    text: {
        fontSize: 16,
        color: '#243047'
    },
    modalStyle: {
        justifyContent: 'flex-end',
        alignItems: 'center',
        flex: 1,
        backgroundColor: 'rgba(0,0,0,0.2)'
    },
    subView: {
        justifyContent: 'flex-end',
        flexDirection: 'column',
        alignItems: 'center',
        alignSelf: 'stretch',
        width: width,
        backgroundColor: '#fff'
    },
    canlendarStyle: {
        width: width,
        height: 320,
        alignItems: 'center',
        justifyContent: 'center',
        borderTopColor: '#cccccc',
        borderTopWidth: 0.5,
        backgroundColor: 'white',
    },
    actionItemTitle: {
        fontSize: 16,
        color: '#243047',
        textAlign: 'center',
    },
    outArrow: {
        backgroundColor: 'white',
        justifyContent: 'center',
        alignItems: 'center',
        flexDirection: 'row',
        flex: 1
    },
    right_arrow: {
        width: 15,
        height: 15,
        paddingLeft: 10,
        paddingRight: 30
    },
    left_arrow: {
        width: 15,
        height: 15,
        paddingLeft: 30,
        paddingRight: 10
    },
    cancel: {
        alignItems: 'center',
        borderTopWidth: 0,
        width: width,
        height: 50,
        justifyContent: 'center'
    }
})