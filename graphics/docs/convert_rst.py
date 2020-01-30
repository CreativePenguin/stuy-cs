import docutils.core
import sys

if len(sys.argv) == 1:
    print('Error: argument required')
    exit()

docutils.core.publish_file(
    source_path=sys.argv[1],
    destination_path='output.html',
    writer_name='html')
