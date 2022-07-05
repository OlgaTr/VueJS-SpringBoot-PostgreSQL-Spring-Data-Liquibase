<template>
  <div>
    <h2>My notes</h2>
    <table>
      <thead>
      <tr>
        <td>Date</td>
        <td>Title</td>
      </tr>
      </thead>
      <tbody>
      <tr v-for="note in notes" v-bind:key="note.id">
        <td>{{note.date}}</td>
        <td>{{note.title}}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import NotesApi from '../api/NotesApi'

export default {
  name: 'NotesList',
  data: function() {
    return {
      notes: []
    }
  },
  methods: {
    getNotes(){
      NotesApi.getNotes().then(response => {
        this.notes = response.data
      });
    }
  },
  mounted() {
    this.getNotes();
  }
}

</script>

<style scoped>

div {
  border: 1px solid #5D6063;
  margin: 60px 300px;
}

h2 {
  color: #5D6063;
  font-family: sans-serif;
  justify-content: center;
  display: flex;
}

table {
  font-size: 18px;
  color: #5D6063;
  padding: 40px;
  display: flex;
  flex-direction: column;
}

table thead {
  font-size: 20px;
  font-weight: bold;
}

</style>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<!--<style scoped>-->
<!--h3 {-->
<!--  margin: 40px 0 0;-->
<!--}-->
<!--ul {-->
<!--  list-style-type: none;-->
<!--  padding: 0;-->
<!--}-->
<!--li {-->
<!--  display: inline-block;-->
<!--  margin: 0 10px;-->
<!--}-->
<!--a {-->
<!--  color: #42b983;-->
<!--}-->
<!--</style>-->
