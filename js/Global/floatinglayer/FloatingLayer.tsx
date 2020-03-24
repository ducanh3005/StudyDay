/*
    浮层关键类
 */
import React from 'react';
import R from '../../Global/values';
import PropTypes from 'prop-types';

const TITLE_H = 45;
const CANCEL_MARGIN = 0;
const BUTTON_H = 45 + hairlineWidth;
const MAX_HEIGHT = Dimensions.get('window').height * 0.5;

export default class FloatingLayer extends React.Component {
    /**
     * 进行参数校验，在编译时可以发现错误
     */
    static propTypes = {
        titleStyle: PropTypes.object,
        cancelClick: PropTypes.func,
        cancelMargin:PropTypes.number
    }


    constructor(props) {
        super(props);
    }

    render() {

    }
}

