<template>
    <div>
    <input type="name" placeholder="Enter the name of the questionnaire" v-model="name"/>
    <input type="button" value="Save" @click="save"/>
    </div>
</template>

<script>
    function getIndex(list, id) {
        for (var i=0; i < list.length; i++){
            if (list[i].id === id){
                return i
            }
        }
        return -1
    }
    export default {
        props: ['questionnaires','questionnaireAttr'],
        data() {
            return{
                name: '',
                id: ''
            }
        },
        watch: {
            questionnaireAttr(newVal, oldVal){
                this.name=newVal.name;
                this.id=newVal.id
            }
        },
        methods:{
            save() {
                const questionnaire={ name: this.name };

                if (this.id) {
                    this.$resource('/questionnaire{/id}').update({id: this.id}, questionnaire).then(result =>
                        result.json().then(data => {
                            const index = getIndex(this.questionnaires, data.id);
                            this.questionnaires.splice(index, 1, data);
                            this.name = '';
                            this.id = '';
                        })
                    )
                } else {
                    this.$resource('/questionnaire{/id}').save({}, questionnaire).then(result =>
                        result.json().then(data => {
                            this.questionnaires.push(data);
                            this.name = '';
                        })
                    )
                }
            }}
    }
</script>

<style>

</style>