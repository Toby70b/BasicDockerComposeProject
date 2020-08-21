import React, {useState, useEffect} from 'react';
import {Row, Card, Typography, Col, Table, Checkbox} from 'antd';
import WrappedHorizontalForm from "../WrappedHorizontalForm";

const {Title} = Typography;

function TodoPage() {
    const [todoItems, setTodoItemsArray] = useState([]);
    useEffect(() => {
        getTodoItems();
    }, []);


    const onTaskCompleted = (recordId) => {
        console.log("Deleting Record " + recordId);

        var options = {
            method: 'DELETE',
            headers: {'Content-Type': 'application/json;'},
        }

        fetch('http://127.0.0.1:8090/api/todo/' + recordId, options)
            .then(() => getTodoItems());
    }

    const columns = [
        {
            title: 'Task',
            dataIndex: 'message',
            key: 'message',

        },
        {
            title: 'Completed?',
            key: 'completed',
            render: (record) =>
                <Checkbox onChange={() => onTaskCompleted(record.id)} defaultChecked={record.completed}/>
        }
    ]

    const getTodoItems = () => {
        var options = {
            method: 'GET',
            headers: {'Content-Type': 'application/json;'},
        }

        fetch('http://127.0.0.1:8090/api/todo/', options)
            .then((response) => response.json())
            .then((jsonResponse) => {
                setTodoItemsArray(jsonResponse);
            });
    }


    const onSubmitForm = (formData) => {
        var options = {
            method: 'POST', // *GET, POST, PUT, DELETE, etc.
            headers: {'Content-Type': 'application/json;'},
            body: JSON.stringify({"message": formData.message})
        }

        fetch('http://127.0.0.1:8090/api/todo/', options)
            .then(() => getTodoItems());

    }


    return (
        <div>
            <Row type="flex" justify="center">
                <Title>Todo Tracker</Title>
            </Row>
            <Row type="flex" justify="center">
                <Col xs={24} lg={12}>
                    <Card title={<h2>Add new Todo item</h2>}>
                        <div style={{marginBottom: 16}}>
                            <WrappedHorizontalForm onSubmit={onSubmitForm}/>
                            <Table dataSource={todoItems} columns={columns} rowKey={record => record.id}/>
                        </div>
                    </Card>
                </Col>
            </Row>
        </div>
    );
}

export default TodoPage

