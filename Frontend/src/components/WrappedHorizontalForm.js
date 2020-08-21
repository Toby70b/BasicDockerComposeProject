import React, {useState} from 'react';
import 'antd/dist/antd.css';
import { Form, Input, Button, Select } from 'antd';
const layout = {
    labelCol: {
        span: 4,
    },
    wrapperCol: {
        span: 10,
    },
};
const tailLayout = {
    wrapperCol: {
        offset: 4,
        span: 16,
    },
};


function WrappedHorizontalForm(props) {
    const [form] = Form.useForm();

    return (
        <Form {...layout} form={form} name="control-hooks" onFinish={props.onSubmit}>
            <Form.Item
                name="message"
                label="Task"
                rules={[
                    {
                        required: true,
                    },
                ]}
            >
                <Input />
            </Form.Item>
            <Form.Item {...tailLayout}>
                <Button type="primary" htmlType="submit">
                    Submit
                </Button>
            </Form.Item>
        </Form>
    );
};

export default WrappedHorizontalForm;
